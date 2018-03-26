package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.passive;

import java.util.List;

import com.yimi.mobile.common.ConstantUtil.WX_MSG_TYPE;

public class PassiveMessageNews extends PassiveBaseMessage {

	private int ArticleCount;

	private List<PassiveArticle> Articles;

	public PassiveMessageNews() {
		this.setMsgType(WX_MSG_TYPE.news.toString());
	}
	
	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<PassiveArticle> getArticles() {
		return Articles;
	}

	public void setArticles(List<PassiveArticle> articles) {
		Articles = articles;
	}
	
}
