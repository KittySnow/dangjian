package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PPicture;
import cn.dlbdata.dangjian.admin.dao.model.PPictureExample;
import cn.dlbdata.dangjian.admin.service.PPictureService;
import cn.dlbdata.dangjian.common.util.CookieUtil;
import cn.dlbdata.dangjian.common.util.FileUtil;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.AccessTokenResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetaAccessTokenParam;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GrantType;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.AccessService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.CommonUtil;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.LocalCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * @packageName PPictureController
 * @anthor wayne QQ:353733479
 * @date 2018/3/31.
 * @change
 * @describe 上传显示图片处理接口
 */
@Controller
@RequestMapping("/picture")
public class PPictureController {
    private final Logger logger = LoggerFactory.getLogger(PPictureController.class);

    private final String PICTURE_PATH = "C:\\upload\\picture";
    private final String PREVFIX = "thumbnail_";

    @Autowired
    private PPictureService pPictureService;

    @Autowired
    private AccessService accessService;
    /**
     * 上传图片
     *
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> upload(String mediaId, HttpServletRequest request) {
        ResultUtil result = new ResultUtil();
        String path;
        try {
            path = downloadMedia(mediaId, PICTURE_PATH);
            thumbnailImage(path,200,200,PREVFIX,false);
        }catch (Exception e){
            result.setMsg("保存图片失败");
            result.setSuccess(false);
            return result.getResult();
        }

        PPicture picture = new PPicture();
        picture.setCreateTime(new Date());
        picture.setUrl(path);
        int pictureId = pPictureService.insert(picture);
        result.setData(pictureId);
        result.setMsg("上传图片成功！");
        result.setSuccess(true);
        //返回json
        return result.getResult();
    }

    /**
     * 显示图片
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public void showPicture(Integer pictureId,HttpServletResponse response) {
        PPicture picture = pPictureService.selectByPrimaryKey(pictureId);
        String path = picture.getUrl();
        logger.info("imgPath = " + path);
        InputStream is = null;
        OutputStream os = null;
        try {
            try {
                is = new FileInputStream(path);
                response.setContentType("image/jpeg");
                // 设置页面不缓存
                response.setHeader("Pragma", "No-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
                os = response.getOutputStream();//取得响应输出流

                int count;
                byte[] buffer = new byte[1024 * 1024];
                while ((count = is.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }
            }  catch (Exception e) {
                logger.error(e.getMessage(), e);
            } finally {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
    /**
     * 显示缩略图片
     */
    @RequestMapping(value = "/showThumbnail", method = RequestMethod.GET)
    public void showThumbnailPicture(Integer pictureId,HttpServletResponse response) {
        PPicture picture = pPictureService.selectByPrimaryKey(pictureId);
        String path = picture.getUrl();
        logger.info("imgPath = " + path);
        InputStream is = null;
        OutputStream os = null;
        try {
            try {
                File imgFile = new File(path);
                String thumbnailPath = path.substring(0, path.lastIndexOf(File.separator)) + File.separator + PREVFIX + imgFile.getName();
                is = new FileInputStream(thumbnailPath);
                response.setContentType("image/jpeg");
                // 设置页面不缓存
                response.setHeader("Pragma", "No-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
                os = response.getOutputStream();//取得响应输出流

                int count;
                byte[] buffer = new byte[1024 * 1024];
                while ((count = is.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }
            }  catch (Exception e) {
                logger.error(e.getMessage(), e);
            } finally {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        PPictureExample example = new PPictureExample();
        if(pPictureService.deleteByPrimaryKey(id)>0){
            result.setSuccess(true);
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
            result.setSuccess(false);
        }
        return result.getResult();
    }


    @RequestMapping(value="/updateById",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateById(PPicture pPicture){
        ResultUtil result = new ResultUtil();
        if(pPictureService.updateByPrimaryKey(pPicture)>0){
            result.setSuccess(true);
            result.setMsg("修改成功");
        }else{
            result.setSuccess(false);
            result.setMsg("修改失败");
        }
        return result.getResult();
    }

    @RequestMapping(value="/queryById",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryById(Integer id){
        ResultUtil result = new ResultUtil();
        PPicture pPicture = pPictureService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pPicture);
        return result.getResult();
    }


    /**
     * 获取媒体文件
     *
     * @param mediaId  媒体文件id
     * @param savePath 文件在本地服务器上的存储路径
     */
    public String downloadMedia(String mediaId, String savePath) throws Exception {

        String filePath = null;

        GetaAccessTokenParam getaAccessTokenParam = new GetaAccessTokenParam();
        getaAccessTokenParam.setSecret("8d72463ffdf8a2232241985b442c1c93");
        getaAccessTokenParam.setAppid("wxef4c83c01085bb38");
        getaAccessTokenParam.setGrantType(GrantType.client_credential);
        String Token = LocalCache.TICKET_CACHE.getIfPresent("ACCESS_TOKEN");
        if (null == Token || "".equals(Token)) {
            AccessTokenResponse accessTokenResponse = accessService.getAccessToken(getaAccessTokenParam);
            Token = accessTokenResponse.getAccessToken();
            LocalCache.TICKET_CACHE.put("ACCESS_TOKEN", Token);
        }
        // 拼接请求地址
        String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", Token).replace("MEDIA_ID", mediaId);
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoInput(true);
        conn.setRequestMethod("GET");

        if (!savePath.endsWith("/")) {
            savePath += "/";
        }
        // 根据内容类型获取扩展名
        String fileExt = CommonUtil.getFileExt(conn.getHeaderField("Content-Type"));
        //错误的代码 凑活一下！！！！
        if(fileExt.isEmpty()){
            fileExt = ".jpg";
        }
        // 将mediaId作为文件名
        filePath = savePath + System.currentTimeMillis() + fileExt;
        BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        byte[] buf = new byte[8096];
        int size = 0;
        while ((size = bis.read(buf)) != -1)
            fos.write(buf, 0, size);
        fos.close();
        bis.close();
        conn.disconnect();
        logger.info("下载媒体文件成功，filePath=" + filePath);
        return filePath;
    }

    /**
     * <p>Title: thumbnailImage</p>
     * <p>Description: 依据图片路径生成缩略图 </p>
     * @param imagePath    原图片路径
     * @param w            缩略图宽
     * @param h            缩略图高
     * @param prevfix    生成缩略图的前缀
     * @param force        是否强制依照宽高生成缩略图(假设为false，则生成最佳比例缩略图)
     */
    private void thumbnailImage(String imagePath, int w, int h, String prevfix, boolean force){
        File imgFile = new File(imagePath);
        if(imgFile.exists()){
            try {
                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                String types = Arrays.toString(ImageIO.getReaderFormatNames());
                String suffix = null;
                // 获取图片后缀
                if(imgFile.getName().indexOf(".") > -1) {
                    suffix = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
                }// 类型和图片后缀所有小写，然后推断后缀是否合法
                if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()) < 0){
                    logger.error("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
                    return ;
                }
                logger.debug("target image's size, width:{}, height:{}.",w,h);
                Image img = ImageIO.read(imgFile);
                if(!force){
                    // 依据原图与要求的缩略图比例，找到最合适的缩略图比例
                    int width = img.getWidth(null);
                    int height = img.getHeight(null);
                    if((width*1.0)/w < (height*1.0)/h){
                        if(width > w){
                            h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w/(width*1.0)));
                            logger.debug("change image's height, width:{}, height:{}.",w,h);
                        }
                    } else {
                        if(height > h){
                            w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
                            logger.debug("change image's width, width:{}, height:{}.",w,h);
                        }
                    }
                }
                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
                g.dispose();
                String p = imgFile.getPath();
                // 将图片保存在原文件夹并加上前缀
                ImageIO.write(bi, suffix, new File(p.substring(0,p.lastIndexOf(File.separator)) + File.separator + prevfix +imgFile.getName()));
                logger.debug("缩略图在原路径下生成成功");
            } catch (IOException e) {
                logger.error("generate thumbnail image failed.",e);
            }
        }else{
            logger.warn("the image is not exist.");
        }
    }
}