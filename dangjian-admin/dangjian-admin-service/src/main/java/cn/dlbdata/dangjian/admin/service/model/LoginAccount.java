package cn.dlbdata.dangjian.admin.service.model;

public class LoginAccount {
	private String loginMail;
	private java.util.Date loggedTime;//登录时间。
	private String ip;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	private Boolean isLocked;
	private java.util.Date lockedTime;//账号被锁定的开始时间。
	
	public String getLoginMail() {
		return loginMail;
	}
	public void setLoginMail(String loginMail) {
		this.loginMail = loginMail;
	}
	public Boolean getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}
	public java.util.Date getLockedTime() {
		return lockedTime;
	}
	public void setLockedTime(java.util.Date lockedTime) {
		this.lockedTime = lockedTime;
	}
	public java.util.Date getLoggedTime() {
		return loggedTime;
	}
	public void setLoggedTime(java.util.Date loggedTime) {
		this.loggedTime = loggedTime;
	}
}