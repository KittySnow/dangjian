package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.passive;


import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.ConstantUtil;

public class PassiveMessageImg extends PassiveBaseMessage {
	// 回复的消息内容
	private PassiveImage Image;

	public PassiveMessageImg() {
		this.setMsgType(ConstantUtil.WX_MSG_TYPE.image.toString());
	}
	
	public PassiveImage getImage() {
		return Image;
	}

	public void setImage(PassiveImage image) {
		Image = image;
	}
	
}
