package cn.dlbdata.dangjian.admin.service.impl;

import cn.dlbdata.dangjian.admin.dao.mapper.PUserDao;
import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.service.ADService;
import cn.dlbdata.dangjian.admin.service.model.LoginAccount;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static cn.dlbdata.dangjian.admin.service.util.DangjianUtil.getMD5;

@Service("ADService")
public class ADServiceImpl implements ADService {
	/*
	@Autowired
	private IAlarmDAO alarmDao;
	*/
	
	/*
	@Autowired
	private IasDAO iasDao;
	*/
	
    @Resource
	PUserDao pUserDao;


	private static final long DEFAULT_ACCOUNT_LOCK_TIME	= 1*60*1000*60*3;//1分钟。
	private static final int MAX_LOGIN_RETRY	= 5;
	//被锁定账号映射表。
	private static Map<String,LoginAccount> lockedAccountMap= new HashMap<String,LoginAccount>();
	//登录错误次数。
	private static Map<String,Integer> loginErrorMap= new HashMap<String,Integer>();//key is login mail, value is login numbers.
	//已成功登录账号列表。
	private static Map<String,String> loginIpMap	= new HashMap<String,String>();	//key is login mail, value is login ip.
	

	@Override
	public int checkLogin(final String loginMail, final String loginPasswd, final String fromIp) {
		final String loginOKMail= "dlbdata.cn";
		final String loginOKPass= "dlbDE160729";
		final String lowercase	= loginMail.toLowerCase();
		int ret	= 3;	//已登录，不可以再次登录。
		if (loginIpMap.containsKey(lowercase))	{
			return ret;
		}
		
		//检查登录账号是否已被锁定了。
		long curr	= System.currentTimeMillis();
		boolean isLocked= lockedAccountMap.containsKey(lowercase);
		if (isLocked)	{
			//账号已被锁定了。
			if ((curr - lockedAccountMap.get(lowercase).getLockedTime().getTime())>DEFAULT_ACCOUNT_LOCK_TIME)	{
				//账号锁定超时，解锁后重新验证。
				lockedAccountMap.remove(lowercase);
				loginErrorMap.remove(lowercase);
			} else {
				//账号继续锁定，不解锁。
				ret	= 2;
				return ret;
			}
		}
		
		//验证流程。
		if (lowercase.equals(loginOKMail) && loginPasswd.equals(loginOKPass))	{
			//验证通过，登录成功。
			ret	= 0;
			loginIpMap.put(lowercase, fromIp);
		} else {
			if (!loginErrorMap.containsKey(lowercase))	{
				loginErrorMap.put(lowercase, 1);
				ret	= 1;
			} else {
				Integer cnt	= loginErrorMap.get(lowercase) + 1;
				loginErrorMap.put(lowercase, cnt);
				if (cnt==MAX_LOGIN_RETRY)	{
					ret	= 2;
					LoginAccount la	= new LoginAccount();
					la.setIsLocked(true);
					la.setLoginMail(loginMail);
					la.setLockedTime(new Date(curr));
					lockedAccountMap.put(lowercase, la);
				} else {
					ret	= 1;
				}
			}
		}
			
		return ret;
	}

	@Override
	public boolean logout(final String loginMail)	{
		Object value= loginIpMap.remove(loginMail);
		if (null==value)	return false;
		return true;
	}
	
	@Override
	public String getLastLoginIp(final String loginMail)	{
		return loginIpMap.get(loginMail.toLowerCase());
	}

	@Override
	public int login(final String lowercase, final String loginPasswd, final String fromIp) {
		int ret	= 3;	//已登录，不可以再次登录。
		if (loginIpMap.containsKey(lowercase))	{
			return ret;
		}
		
		//检查登录账号是否已被锁定了。
		long curr	= System.currentTimeMillis();
		boolean isLocked= lockedAccountMap.containsKey(lowercase);
		if (isLocked)	{
			//账号已被锁定了。
			if ((curr - lockedAccountMap.get(lowercase).getLockedTime().getTime())>DEFAULT_ACCOUNT_LOCK_TIME)	{
				//账号锁定超时，解锁后重新验证。
				lockedAccountMap.remove(lowercase);
				loginErrorMap.remove(lowercase);
			} else {
				//账号继续锁定，不解锁。
				ret	= 2;
				return ret;
			}
		}
		
		//验证流程。
		PUser u	= pUserDao.selectByEmail(lowercase);
		if (null!=u && getMD5(loginPasswd).equals(u.getPassword()))	{
			//验证通过，登录成功。
			ret	= 0;
			loginIpMap.put(lowercase, fromIp);
		} else {
			if (!loginErrorMap.containsKey(lowercase))	{
				loginErrorMap.put(lowercase, 1);
				ret	= 1;
			} else {
				Integer cnt	= loginErrorMap.get(lowercase) + 1;
				loginErrorMap.put(lowercase, cnt);
				if (cnt==MAX_LOGIN_RETRY)	{
					ret	= 2;
					LoginAccount la	= new LoginAccount();
					la.setIsLocked(true);
					la.setLoginMail(lowercase);
					la.setLockedTime(new Date(curr));
					lockedAccountMap.put(lowercase, la);
				} else {
					ret	= 1;
				}
			}
		}
			
		return ret;
	}

}