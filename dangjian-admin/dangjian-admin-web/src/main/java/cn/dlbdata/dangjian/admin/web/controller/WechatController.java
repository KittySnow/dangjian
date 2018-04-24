package cn.dlbdata.dangjian.admin.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.common.dispatcher.EventDispatcher;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.common.dispatcher.MsgDispatcher;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.MessageUtil;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * ClassName: WechatController
 * @Description: 实现类
 * @author XiaoJiu
 * @date 2017-10-17
 */
@Controller
@RequestMapping("/wx")
public class WechatController {
	private static Logger logger = Logger.getLogger(WechatController.class);
	
	/**
	 * @Description: 用于接收 get 参数，返回验证参数
	 * @param request
	 * @param response
	 * @return void
	 * @author XiaoJiu
	 * @throws IOException 
	 * @date 2017-10-17
	 */
	@RequestMapping(value = "/wechat", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 微信加密签
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败

		PrintWriter out = response.getWriter();

        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
        }

		out.close();
		out = null;
	}

	/**
	 * @Description: 方法用于接收微信服务端消息
	 * @param request
	 * @param response
	 * @return void
	 * @author XiaoJiu
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 * @date 2017-10-17
	 */
	@RequestMapping(value = "/wechat", method = RequestMethod.POST)
	// post 方法用于接收微信服务端消息
	public void DoPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码
        response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上

		Map<String, String> map = MessageUtil.parseXml(request);
        String msgType = map.get("MsgType");

		PrintWriter out = response.getWriter();

		if(msgType!=null){
			if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)){
				logger.info("WechatController->DoPost->EventDispatcher start");
				out.write(EventDispatcher.processEvent(map)); 	//进入事件处理
			}else{
				logger.info("WechatController->DoPost->MsgDispatcher start");
				out.write(MsgDispatcher.processMessage(map));	//进入消息处理
			}
		}else{
			logger.info("微信方法失效");
		}


		out.close();
		out = null;
	}
}