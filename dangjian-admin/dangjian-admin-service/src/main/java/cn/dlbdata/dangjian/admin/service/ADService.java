package cn.dlbdata.dangjian.admin.service;


public interface ADService {
	

	//执行登录流程。
	public int checkLogin(final String loginMail, final String loginPasswd, final String fromIp);
	public int login(final String lowercaseMail, final String loginPasswd, final String fromIp);
	
	//执行登录退出流程。
	public boolean logout(final String loginMail);
	
	//查询登录账号loginMail的最后1次登录IP地址。
	public String getLastLoginIp(final String loginMail);
}