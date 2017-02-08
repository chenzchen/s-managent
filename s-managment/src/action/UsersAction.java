package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDao;
import service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
//����struts2ģ����������
public class UsersAction extends SuperAction implements ModelDriven<Users>{
	private Users user=new Users();
	
	//�û���¼����
	public String login(){
		UsersDao udao=new UsersDAOImpl();
		if(udao.usersLogin(user)){
			//��session�б����¼�ɹ����û���
			session.setAttribute("loginUserName", user.getUsername());
			
			return "login_success";
		}
		else
		{
			return "login_failure";
		}
	}
	//�û�ע��
	@SkipValidation
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}

		return "logout_success";
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//�û�������Ϊ��;
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "�û�������Ϊ��");
			
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "���볤�Ȳ�С��6λ");
		}
	}
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
