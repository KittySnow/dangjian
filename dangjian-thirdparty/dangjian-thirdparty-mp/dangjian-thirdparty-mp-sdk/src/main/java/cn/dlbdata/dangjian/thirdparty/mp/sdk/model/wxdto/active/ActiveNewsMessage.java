package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.active;


import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.ConstantUtil;

/**
 * 主动图文消息
 * 
 * @author Administrator
 *
 */
public class ActiveNewsMessage extends ActiveBaseMessage {
	
	// 回复的消息内容
	private ActiveNews news;

	public ActiveNewsMessage() {
		this.setMsgtype(ConstantUtil.WX_MSG_TYPE.news.toString());
	}

	public ActiveNews getNews() {
		return news;
	}

	public void setNews(ActiveNews news) {
		this.news = news;
	}
	
}
