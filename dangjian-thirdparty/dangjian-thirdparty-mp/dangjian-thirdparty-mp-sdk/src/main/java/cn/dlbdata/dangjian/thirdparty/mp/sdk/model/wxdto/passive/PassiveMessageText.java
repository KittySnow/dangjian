package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.passive;

import com.yimi.mobile.common.ConstantUtil.WX_MSG_TYPE;

public class PassiveMessageText extends PassiveBaseMessage {
	
	// 回复的消息内容
	private String Content;

	public PassiveMessageText() {
		this.setMsgType(WX_MSG_TYPE.text.toString());
	}
	
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
}
