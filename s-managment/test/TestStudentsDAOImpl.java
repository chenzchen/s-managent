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
		StudentsDao sdao=new StudentsDAOImpl();//�ӿ�?
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
		Students stu=new Students(null, "��Ѱ��", "��", new Date(), "ĳĳ�ط�");
		StudentsDao sdao=new StudentsDAOImpl();
		Assert.assertEquals(true, sdao.addStudents(stu));
	}
	
}
