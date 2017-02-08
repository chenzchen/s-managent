package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import service.StudentsDao;
import service.impl.StudentsDAOImpl;
import com.opensymphony.xwork2.ActionSupport;
import entity.Students;

public class StudentsAction extends SuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//查询所有学生的动作
	public String query(){
		StudentsDao sdao=new StudentsDAOImpl();
		List<Students> list=sdao.queryAllStudents();
		//写入session中
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list",list);
		}
		return "query_success";
	}
	//删除学生动作
	public String delete(){
		StudentsDao sdao=new StudentsDAOImpl();
		String sid=request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
		}
	//添加学生动作
	public String add() throws ParseException{
		StudentsDao sdao = new StudentsDAOImpl();
		String Sname = request.getParameter("name");
		String Sgender = request.getParameter("gender");
		String Saddress = request.getParameter("address");
		Students s = new Students();
		s.setAddress(Saddress);
		s.setBirthday(new Date());
		s.setGender(Sgender);
		s.setName(Sname);
		sdao.addStudents(s);
		return "add_success";
	}
	}
