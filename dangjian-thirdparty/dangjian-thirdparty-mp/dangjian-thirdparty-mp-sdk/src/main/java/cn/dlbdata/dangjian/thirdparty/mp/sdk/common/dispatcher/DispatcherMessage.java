package cn.dlbdata.dangjian.thirdparty.mp.sdk.common.dispatcher;

import com.xiaojiu.ssm.pojo.Video;
import com.xiaojiu.ssm.service.IVideoService;
import com.xiaojiu.wechat.A.message.res.Article;
import com.xiaojiu.wechat.A.message.res.NewsMessage;
import com.xiaojiu.wechat.A.message.res.TextMessage;
import com.xiaojiu.wechat.B.util.MessageUtil;
import com.xiaojiu.wechat.B.util.SpiderByCUtils;
import com.xiaojiu.wechat.C.api.message.TuLingMessage;
import com.xiaojiu.wechat.C.api.util.TuLingApiUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DispatcherMessage {
	private static Logger logger = Logger.getLogger(DispatcherMessage.class);
	
	@Resource
	private IVideoService videoService;
	
	private static DispatcherMessage dispatcherMessage;
	
	@PostConstruct
	public void init(){
		dispatcherMessage = this;
		dispatcherMessage.videoService = this.videoService;
	}

	/**
	 * @Description: 主菜单信息
	 * @param @return
	 * @author XiaoJiu
	 * @date 2017-10-28
	 */
	public static String getMainMenu(){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("你好，我是小玖，请回复数字选择服务：").append("\n\n");
		stringBuffer.append("1　电影搜索").append("\n");
		stringBuffer.append("2　小玖购物").append("\n");
		stringBuffer.append("3　小玖聊天").append("\n");
		return stringBuffer.toString();
	}

	/**
	 * @Description: 电影搜索菜单
	 * @param @return
	 * @author XiaoJiu
	 * @date 2017-10-28
	 */
	public static String getMovieMenu(){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("电影搜索操作指南").append("\n\n");
		stringBuffer.append("回复：电影+电影名").append("\n");
		stringBuffer.append("例如：电影战狼2").append("\n");
		return stringBuffer.toString();
	}

	public static String getMovie(String content) throws Exception{
		String searchWord = content.replaceAll("^电影[\\+ ~!@#%^-_=]?", "");
		if("".equals(searchWord)){
			return getMovieMenu();
		}
		else {
			List<Video> list = dispatcherMessage.videoService.listByVname(searchWord);
			if(list != null && list.size() > 0){
				StringBuffer stringBuffer = new StringBuffer();
				for(int i=0; i<list.size(); i++){
					stringBuffer.append(list.get(i).getVname()).append("\n");
					stringBuffer.append(list.get(i).getVurl()).append("\n");
				}
				if(stringBuffer.toString().getBytes("utf-8").length >= 2048){
					String url = "";
					String[] urls = stringBuffer.toString().split("\\n");
					for(int i=0; i<urls.length; i++){
						if((url + urls[i]).getBytes("utf-8").length < 2048){
							url += urls[i];
						}
					}
					return url;
				}
				return stringBuffer.toString();
			}
			else {
				List<Video> videos = SpiderByCUtils.getHtml("http://www.czhiyun.com/search.asp?searchword="+URLEncoder.encode(searchWord, "gb2312"));
				if(videos.size() != 0){
					String url = "";
					for(int i=0; i<videos.size(); i++){
						logger.info("total: "+videos.size()+" counts, "+"current: "+i+" count start ..");
						dispatcherMessage.videoService.insert(videos.get(i));
						url += videos.get(i).getVurl();
					}
					return url;
				}
				else {
					return searchWord + " 此资源未更新, 请联系小玖( 805564465 ) ..\n";
				}
			}
		}
	}

	/**
	 * @Description: 小玖购物菜单
	 * @param @return
	 * @author XiaoJiu
	 * @date 2017-10-28
	 */
	public static String getGoodsMenu(){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("此功能尚未开通　敬请期待 ..").append("\n");
		return stringBuffer.toString();
	}

	/**
	 * @Description: 小玖聊天菜单
	 * @param @return
	 * @author XiaoJiu
	 * @date 2017-10-28
	 */
	public static String getChatMenu(){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("小玖聊天操作指南").append("\n\n");
		stringBuffer.append("回复：聊天+内容").append("\n");
		stringBuffer.append("例如：聊天小玖你好").append("\n");
		return stringBuffer.toString();
	}

	public static String getChat(String openId, String mPid, String content) throws Exception{

		/*
    	Code	说明
    	100000	文本类
    	200000	链接类
    	302000	新闻类
    	308000	菜谱类
    	313000（儿童版）	儿歌类
    	314000（儿童版）	诗词类

    	40001	参数key错误
    	40002	请求内容info为空
    	40004	当天请求次数已使用完
    	40007	数据格式异常
		 */
		content = content.replaceAll("^聊天[\\+ ~!@#%^-_=]?", "");
		TuLingMessage tuLingMessage = TuLingApiUtils.getTulingResult(content);
		// 100000|313000|314000|40001|40002|40004|40007 -> 文本类
		if(tuLingMessage.getCode() == 100000){
			TextMessage txtMsg = new TextMessage();
			txtMsg.setToUserName(openId);
			txtMsg.setFromUserName(mPid);
			txtMsg.setCreateTime(new Date().getTime());
			txtMsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			txtMsg.setContent(tuLingMessage.getTextMessage().getText());
			return MessageUtil.textMessageToXml(txtMsg);
		}
		// 200000 -> 链接类
		else if(tuLingMessage.getCode() == 200000){
			TextMessage txtMsg = new TextMessage();
			txtMsg.setToUserName(openId);
			txtMsg.setFromUserName(mPid);
			txtMsg.setCreateTime(new Date().getTime());
			txtMsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			txtMsg.setContent(
					tuLingMessage.getLinkMessage().getText()
					+ "\n" 
					+ "<a href=\""+tuLingMessage.getLinkMessage().getUrl()+"\">打开页面</a>");
			return MessageUtil.textMessageToXml(txtMsg);
		}
		// 302000 -> 新闻类
		else if(tuLingMessage.getCode() == 302000){
			NewsMessage newsMessage = new NewsMessage();
			newsMessage.setToUserName(openId);
			newsMessage.setFromUserName(mPid);
			newsMessage.setCreateTime(new Date().getTime());
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			newsMessage.setArticleCount(tuLingMessage.getNewsMessage().getList().size());
			List<Article> articles = new ArrayList<Article>();
			for (int i = 0; i < tuLingMessage.getNewsMessage().getList().size(); i++) {
				Article article = new Article();
				article.setTitle(tuLingMessage.getNewsMessage().getList().get(i).getArticle());
				article.setDescription(tuLingMessage.getNewsMessage().getList().get(i).getSource());
				article.setPicUrl(tuLingMessage.getNewsMessage().getList().get(i).getIcon());
				article.setUrl(tuLingMessage.getNewsMessage().getList().get(i).getDetailurl());
				articles.add(article);
			}
			newsMessage.setArticles(articles);
			return MessageUtil.newsMessageToXml(newsMessage);
		}
		// 308000 -> 菜谱类
		else if(tuLingMessage.getCode() == 308000){
			NewsMessage newsMessage = new NewsMessage();
			newsMessage.setToUserName(openId);
			newsMessage.setFromUserName(mPid);
			newsMessage.setCreateTime(new Date().getTime());
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			newsMessage.setArticleCount(tuLingMessage.getMenuMessage().getList().size());
			List<Article> articles = new ArrayList<Article>();
			for (int i = 0; i < tuLingMessage.getMenuMessage().getList().size(); i++) {
				Article article = new Article();
				article.setTitle(tuLingMessage.getMenuMessage().getList().get(i).getName());
				article.setDescription(tuLingMessage.getMenuMessage().getList().get(i).getInfo());
				article.setPicUrl(tuLingMessage.getMenuMessage().getList().get(i).getIcon());
				article.setUrl(tuLingMessage.getMenuMessage().getList().get(i).getDetailurl());
				articles.add(article);
			}
			newsMessage.setArticles(articles);
			return MessageUtil.newsMessageToXml(newsMessage);
		}
		else {
			TextMessage txtMsg = new TextMessage();
			txtMsg.setToUserName(openId);
			txtMsg.setFromUserName(mPid);
			txtMsg.setCreateTime(new Date().getTime());
			txtMsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			txtMsg.setContent("小玖已休息, 请稍后再来 ..\n" + getMainMenu());
			return MessageUtil.textMessageToXml(txtMsg);
		}
	}
}
