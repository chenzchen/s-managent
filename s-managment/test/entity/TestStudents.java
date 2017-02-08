package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;





public class TestStudents {
	@Test
	public void testSchemaExport(){
		//创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
	    ServiceRegistry ssr=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	    
		//
		SessionFactory sessionFactory=config.buildSessionFactory(ssr);
		//创建session
		Session session=sessionFactory.getCurrentSession();
		//生成表结构
		SchemaExport export=new SchemaExport(config);
		export.create(true,true);
	}
	//添加测试数据
	@Test
	public void testSaveStudents(){
		//创建配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
	    ServiceRegistry ssr=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	    
		//
		SessionFactory sessionFactory=config.buildSessionFactory(ssr);
		//创建session
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Students  s1=new Students("s0001","张三丰", "男", new Date(), "武当山");
		Students  s2=new Students("s0002","张无忌", "男", new Date(), "明教");
		Students  s3=new Students("s0003","黄药师", "男", new Date(), "桃花岛");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		tx.commit();
		sessionFactory.close();
	}
}
