package kr.co.lifesaver.domain;

public class LifeSaverAdminLoginDTO {
	private String id;
	private String pwd;
	
	public LifeSaverAdminLoginDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public LifeSaverAdminLoginDTO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}



	public String getId() {
		return id;
	}



	public String getPwd() {
		return pwd;
	}



	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
