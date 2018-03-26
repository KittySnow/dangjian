package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.active;

/**
 * 被动消息
 * 
 * @author Administrator
 * 
 */
public abstract class ActiveBaseMessage {

	// 调用接口凭证
	private String access_token;

	// 普通用户openid
	private String touser;

	// 消息类型
	private String msgtype;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

}
