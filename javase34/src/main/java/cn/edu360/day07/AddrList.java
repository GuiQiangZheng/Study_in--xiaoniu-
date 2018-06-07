package cn.edu360.day07;

public class AddrList {
	private String name;
	private String admName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	@Override
	public String toString() {
		return "AddrList [name=" + name + ", admName=" + admName + "]";
	}
	

}
