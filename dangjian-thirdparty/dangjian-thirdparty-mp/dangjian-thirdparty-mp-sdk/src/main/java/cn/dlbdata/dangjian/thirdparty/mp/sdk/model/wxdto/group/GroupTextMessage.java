package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.group;


import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.ConstantUtil;

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
		this.setMsgtype(ConstantUtil.WX_MSG_TYPE.text.toString());
	}

	public GroupText getText() {
		return text;
	}

	public void setText(GroupText text) {
		this.text = text;
	}

}
