import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import service.StudentsDao;
import service.impl.StudentsDAOImpl;

import entity.Students;


public class TestStudentsDAOImpl {
	@Test
	public void testQueryAllStudents(){
		StudentsDao sdao=new StudentsDAOImpl();//接口?
		List<Students> list=sdao.queryAllStudents();
		for (Students students : list) {
			System.out.println(students.toString());
		}
	}
	@Test
	public void testGetNewSid(){
		StudentsDAOImpl sdao=new StudentsDAOImpl();
		System.out.println(sdao.getNewSid());
	}
	@Test
	public void testAddStu(){
		Students stu=new Students(null, "李寻欢", "男", new Date(), "某某地方");
		StudentsDao sdao=new StudentsDAOImpl();
		Assert.assertEquals(true, sdao.addStudents(stu));
	}
	
}
