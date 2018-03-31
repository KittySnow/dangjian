package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PPicture;
import cn.dlbdata.dangjian.admin.dao.model.PPictureExample;
import cn.dlbdata.dangjian.admin.service.PPictureService;
import cn.dlbdata.dangjian.common.util.CookieUtil;
import cn.dlbdata.dangjian.common.util.FileUtil;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
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

    private final String PICTURE_PATH = "C:\\picture\\";

    @Autowired
    private PPictureService pPictureService;

    /**
     * 上传图片
     *
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        ResultUtil result = new ResultUtil();
        String userId;
        Cookie userIdCookie = CookieUtil.getCookie(request, "userId");
        if (null != userIdCookie) {
            userId = userIdCookie.getValue();
        } else {
            userId = request.getHeader("userId");
        }
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = file.getOriginalFilename().substring(fileName.lastIndexOf("."));

        fileName = System.currentTimeMillis() + "_" + userId + "." + suffixName;
        try {
            FileUtil.uploadFile(file.getBytes(), PICTURE_PATH, fileName);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage(), e);
            result.setSuccess(false);
            result.setMsg("上传图片失败！");
            return result.getResult();
        }
        PPicture picture = new PPicture();
        picture.setCreateTime(new Date());
        picture.setUrl(PICTURE_PATH + fileName);
        int pictureId = pPictureService.insert(picture);
        result.setData(pictureId);
        result.setMsg("上传图片成功！");
        //返回json
        return result.getResult();
    }

    /**
     * 显示图片
     */
    @RequestMapping(value = "/show", method = RequestMethod.POST)
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
}