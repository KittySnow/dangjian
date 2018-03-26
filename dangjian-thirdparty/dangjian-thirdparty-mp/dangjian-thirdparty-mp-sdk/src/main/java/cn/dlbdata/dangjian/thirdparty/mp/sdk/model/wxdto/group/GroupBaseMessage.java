package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.group;

import java.util.List;

/**
 * 群发消息基本类型
 * 
 * @author lxl
 *
 */
public class GroupBaseMessage {
	
	// 普通用户openid
	private List<String> touser;
	
	// 消息类型
	private String msgtype;

	public List<String> getTouser() {
		return touser;
	}

	public void setTouser(List<String> touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

}
