package service.impl;


import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;

import entity.Users;
import service.UsersDao;

public class UsersDAOImpl implements UsersDao{

	@Override
	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		String hql="";
		try
		{
			
			Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql= "from Users where username=? and password=?";//ʹ����ռλ�����ȴ����ݲ���
			Query query=session.createQuery(hql);
			query.setParameter(0,u.getUsername());//���ݲ���
			query.setParameter(1,u.getPassword());
			List list=(List) query.list();
			tx.commit();
			if(list.size()>0){
				return true;
			}
			else{
				return false;}
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			if(tx!=null){
				
				tx=null;
			}
		}
		
	}
	
}
