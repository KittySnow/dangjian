package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.res;

import java.util.List;

/**
 * ClassName: NewsMessage
 * @Description: 多图文消息
 * @author XiaoJiu
 * @date 2017-10-18
 */
public class NewsMessage extends BaseMessage{
	// 图文消息个数，限制为 10 条以内   
    private int ArticleCount;  
    // 多条图文消息信息，默认第一个 item 为大图   
    private List<Article> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}  
}
