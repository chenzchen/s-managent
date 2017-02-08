package entity;
import java.util.Date;
public class Students {
	private String sid;//Ñ§ºÅ
	private String name;
	private String gender;
	private Date birthday;
	private String address;
	public Students(){	
	}
	public Students(String sid, String name, String gender, Date birthday,
			String address) {
		super();
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	//²âÊÔÓÃ

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", address=" + address + "]";
	}
	
	
}
