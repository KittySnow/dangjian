package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.res;

/**
 * ClassName: BaseMessage
 * @Description: 返回消息体-基本消息
 * @author XiaoJiu
 * @date 2017-10-18
 */
public class BaseMessage {
	// 接收方帐号（收到的 OpenID）   
    private String ToUserName;  
    // 开发者微信号   
    private String FromUserName;  
    // 消息创建时间 （整型）   
    private long CreateTime;  
    // 消息类型（text/music/news）   
    private String MsgType;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
