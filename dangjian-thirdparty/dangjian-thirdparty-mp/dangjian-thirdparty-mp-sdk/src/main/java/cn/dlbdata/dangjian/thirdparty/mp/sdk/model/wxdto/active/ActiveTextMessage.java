package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.active;

import com.yimi.mobile.common.ConstantUtil.WX_MSG_TYPE;

/**
 * 主动文本消息
 * 
 * @author Administrator
 *
 */
public class ActiveTextMessage extends ActiveBaseMessage {
	
	// 回复的消息内容
	private ActiveText text;

	public ActiveTextMessage() {
		this.setMsgtype(WX_MSG_TYPE.text.toString());
	}

	public ActiveText getText() {
		return text;
	}

	public void setText(ActiveText text) {
		this.text = text;
	}
	
}
