import junit.framework.Assert;

import org.junit.Test;

import service.UsersDao;
import service.impl.UsersDAOImpl;

import entity.Users;


public class TestUsersDAOImpl {
	@Test
	public void testUsersLogin(){
		Users u=new Users(1,"zhangsan","123456") ;
		UsersDao udao=new UsersDAOImpl();
		Assert.assertEquals(true, udao.usersLogin(u)) ;
	}
}
