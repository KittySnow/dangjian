package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.ContentType;
import org.apache.log4j.Logger;


public class HttpUtil {

	private static CloseableHttpClient httpclient = HttpClients.createDefault();
	private static volatile Logger logger = Logger.getLogger(HttpUtil.class);
	/**
	 * http get 请求
	 * 
	 * @param url
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject httpGet(String url) throws ParseException,
			IOException {
		if (StringUtils.isBlank(url)) {
			throw new RuntimeException("url不能为空！");
		}
		// 创建httpget
		HttpGet httpget = new HttpGet(url);
		// 执行get请求
		CloseableHttpResponse response = httpclient.execute(httpget);
		// 获取响应实体
//		HttpEntity entity = response.getEntity();
//		String retSrc = EntityUtils.toString(entity);
		InputStream in = response.getEntity().getContent();
		BufferedReader buf = new BufferedReader(new InputStreamReader(in,"utf-8"));
		StringBuffer retSrc = new StringBuffer();
		String s;
		while ((s = buf.readLine()) != null) {
			retSrc.append(s);
		}
		return JSONObject.fromObject(retSrc.toString());
	}

	/**
	 * http post 请求
	 * 
	 * @param url
	 * @param obj
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject httpPost(String url, Object obj)
			throws ClientProtocolException, IOException {
		if (StringUtils.isBlank(url)) {
			throw new RuntimeException("url不能为空！");
		}
		// 创建httpPost
		HttpPost httpPost = new HttpPost(url);
		if (obj != null) {
			JSONObject jsonObj;
			if (!(obj instanceof JSONObject)) {
				jsonObj = JSONObject.fromObject(obj);
			} else {
				jsonObj = (JSONObject) obj;
			}
//			System.out.println(jsonObj);
			logger.error("群发内容---------"+jsonObj.toString());
			StringEntity strEntity = new StringEntity(jsonObj.toString(),
					"UTF-8");
			httpPost.setEntity(strEntity);
		}
		// 执行post请求
		CloseableHttpResponse response = httpclient.execute(httpPost);
		logger.error("群发完毕--------"+response);
		// 获取响应实体
		HttpEntity entity = response.getEntity();
		String retSrc = EntityUtils.toString(entity);
		logger.error("群发返回结果--------"+retSrc);
		return JSONObject.fromObject(retSrc);
	}

	/**
	 * 微信文件上传
	 * 
	 * @param file
	 * @param accessToken
	 * @param type
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject fileUpload(File file, String accessToken,
			ConstantUtil.WX_MSG_TYPE type) throws ClientProtocolException, IOException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("accessToken不能为空！");
		}
		if (type == null) {
			throw new RuntimeException("type不能为空");
		}
		if (file == null || !file.isFile()) {
			throw new RuntimeException("文件错误");
		}
//		String url = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="
//				+ accessToken + "&type=image";//  + type.toString();
		String url = "http://127.0.0.1:8080/weishop/wxMaterialsManageAction/materialsUpload.do";
		// application/octet-stream
		FileEntity fileEntity = new FileEntity(file, ContentType.MULTIPART_FORM_DATA);
		HttpPost httpPost = new HttpPost(url);
//		Map<String,String> headers = new HashMap<String,String>();
//		headers.put("Content-Disposition", "form-data;name=\"file\"");
//		headers.put("filename", file.getName());
//		headers.put("Content-Type", "application/octet-stream");
//		httpPost.setHeaders(assemblyHeader(headers));
		httpPost.setEntity(fileEntity);
		
		// 执行post请求
		CloseableHttpResponse response = httpclient.execute(httpPost);
		// 获取响应实体
		HttpEntity entity = response.getEntity();
		String retSrc = EntityUtils.toString(entity);
//		System.out.println(retSrc);
		return JSONObject.fromObject(retSrc);
	}

	//这是组装头部
    public static Header[] assemblyHeader(Map<String,String> headers){
        Header[] allHeader= new BasicHeader[headers.size()];
        int i  = 0;
        for (String str :headers.keySet()) {
            allHeader[i] = new BasicHeader(str,headers.get(str));
            i++;
        }
        return allHeader;
    }
	
	public static JSONObject uploadMedia(File file, String accessToken,
			ConstantUtil.WX_MSG_TYPE type) throws Exception {
		logger.error("开始上传");
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("accessToken不能为空！");
		}
		if (type == null) {
			throw new RuntimeException("type不能为空");
		}
		if (file == null || !file.isFile()) {
			throw new RuntimeException("文件错误");
		}
		String result = null;
		/**
		 * 第一部分
		 */
		URL urlObj = new URL(
				"http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="
						+ accessToken

						+ "&type=" + type.toString() + "");
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); // post方式不能使用缓存
		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
				+ BOUNDARY);
		// 请求正文信息
		// 第一部分：
		StringBuilder sb = new StringBuilder();
		sb.append("--"); // 必须多两道线
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
				+ file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		byte[] head = sb.toString().getBytes("utf-8");
		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);
		// 文件正文部分
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();
		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
		out.write(foot);
		out.flush();
		out.close();
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		try {
			logger.error("上传中");
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
			logger.error("结果----------"+result);
		} catch (IOException e) {
			System.out.println("发送POST请求出现异常！" + e);
			logger.error("HTTPPost发送POST请求出现异常！");
			e.printStackTrace();
			throw new IOException("数据读取异常");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return JSONObject.fromObject(result);

	}
	
	/**
	 * 微信文件下载
	 * 
	 * @param accessToken
	 * @param mediaId
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static InputStream fileDownload(String accessToken, String mediaId) throws ClientProtocolException, IOException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("accessToken不能为空！");
		}
		if (StringUtils.isBlank(mediaId)) {
			throw new RuntimeException("mediaId不能为空！");
		}
		String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="
				+ accessToken + "&media_id=" + mediaId;
		HttpPost httpPost = new HttpPost(url);
		// 执行post请求
		CloseableHttpResponse response = httpclient.execute(httpPost);
//		HttpEntity entity = response.getEntity();
//		String retSrc = EntityUtils.toString(entity);
//		System.out.println(retSrc);
		InputStream inputStream = response.getEntity().getContent();
		return inputStream;
	}

}
