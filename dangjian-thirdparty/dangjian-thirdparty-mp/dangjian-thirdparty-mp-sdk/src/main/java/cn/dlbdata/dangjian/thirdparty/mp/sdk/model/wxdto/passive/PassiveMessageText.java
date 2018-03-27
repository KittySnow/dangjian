package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.passive;


import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.ConstantUtil;

public class PassiveMessageText extends PassiveBaseMessage {
	
	// 回复的消息内容
	private String Content;

	public PassiveMessageText() {
		this.setMsgType(ConstantUtil.WX_MSG_TYPE.text.toString());
	}
	
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
}
