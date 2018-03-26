package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.group;

import com.yimi.mobile.common.ConstantUtil.WX_MSG_TYPE;

/**
 * 主动文本消息
 * 
 * @author Administrator
 *
 */
public class GroupTextMessage extends GroupBaseMessage {
	
	// 回复的消息内容
	private GroupText text;

	public GroupTextMessage() {
		this.setMsgtype(WX_MSG_TYPE.text.toString());
	}

	public GroupText getText() {
		return text;
	}

	public void setText(GroupText text) {
		this.text = text;
	}

}
