package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;

import entity.Students;
import service.StudentsDao;

public class StudentsDAOImpl implements StudentsDao{

	@Override
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List<Students> list=null;
		String hql="";
		try
		{
			Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Students";
			Query query=session.createQuery(hql);
			list=query.list();  //顺序不能错
			tx.commit();//顺序不能错
					
			return list;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	
	}

	@Override
	public Students queryStudentsBySid(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addStudents(Students s) {
		// TODO Auto-generated method stub
		s.setSid(getNewSid());//设置学号
		Transaction tx=null;
		try{
			Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		finally{
			tx=null;
		}

	}

	@Override
	public boolean updateStudents(Students s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudents(String sid) {
		// TODO Auto-generated method stub
		Transaction tx=null;
	//	String hql="";
		try
		{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Students s=(Students) session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	
	}
	//生成学生编号
	public String getNewSid(){
		Transaction tx=null;
		String hql="";
		String sid=null;
		try
		{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			//获得当前学生的最大编号
			hql="select max(sid) from Students";
			Query query=session.createQuery(hql);
			sid=(String) query.uniqueResult();
			if(sid==null||"".equals(sid)){
				//给定一个默认的最大变量
				sid="s0001";}
			else{
				String temp=sid.substring(1);
				int i=Integer.parseInt(temp);
				i++;
				//还原为字符串
				temp=String.valueOf(i);
				int len=temp.length();
				//凑够4位
				for(int j=0;j<4-len;j++){
					temp="0"+temp;
				}
				sid="S"+temp;
			}
			tx.commit();
			return sid;
		}
		catch (Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
