package com.example.system.model;

public class User extends BaseModel {

	public User(int u_no, String u_pwd, String u_name, String u_email,
			String u_tel) {
		super();
		this.u_no = u_no;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.u_email = u_email;
		this.u_tel = u_tel;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int u_no;
	
	private String u_pwd;
	
	private String u_name;
	
	private String u_email;
	
	private String u_tel;
	
//	private String latitude;
	
//	private String longtitude;
	
//	private String news;
	
//	private String Areas;


	@Override
    public String toString() {
	return "User [u_no="+u_no+"u_name=" + u_name + ", u_pwd=" + u_pwd + ", u_email=" + u_email
		+ ", u_tel=" + u_tel +  "]";}	/*public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public String getAreas() {
		return Areas;
	}

	public void setAreas(String areas) {
		Areas = areas;
	}*/

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_tel() {
		return u_tel;
	}

	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
