package cn.edu360.day07;

public class BikeBean {
	//{"event_type":0,"page":"/pages/index/index","time":"2018-03-14 12:35:14",
	//"uid":"oDK8U0c_VZqQTMVsab9oM219vZpw","longitude":126.67032,"latitude":45.767525,
	//"province":"黑龙江省","city":"哈尔滨市","district":"南岗区"}
	
	private String event_type;
	private String page;
	private String time;
	private String uid;
	private double longitude;
	private double latitude;
	private String province;
	private String city;
	private String district;
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "BikeBean [event_type=" + event_type + ", page=" + page
				+ ", time=" + time + ", uid=" + uid + ", longitude="
				+ longitude + ", latitude=" + latitude + ", province="
				+ province + ", city=" + city + ", district=" + district + "]";
	}
	
	

}
