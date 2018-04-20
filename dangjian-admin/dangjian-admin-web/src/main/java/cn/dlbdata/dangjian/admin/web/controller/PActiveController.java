package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.*;
import cn.dlbdata.dangjian.admin.service.*;
import cn.dlbdata.dangjian.common.util.DateUtil;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.*;

/**
 * @packageName PActiveController
 * @anthor wayne QQ:353733479
 * @date 2018/3/31.
 * @change
 * @describe 活动接口
 */

@Controller
@RequestMapping("/active")
public class PActiveController {
    private static Logger _log = LoggerFactory.getLogger(PActiveController.class);

    @Autowired
    private PPartymemberService pPartymemberService;
    @Autowired
    private PUserService pUserService;

    @Autowired
    private PActiveService pActiveService;
    @Autowired
    private PPictureService pPictureService;

    @Autowired
    private PActiveParticipateService activeParticipateService;

    @Autowired
    private PScoreDetailService scoreDetailService;

    @Autowired
    private PScorePartyService pScorePartyService;

    /**
     * 创建活动
     * @return
     */
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> create(Long startTime,Long endTime,Integer activeType,Integer activeStatus,
                                      String activeName,String activePace,Integer activeCreatePeople,Integer departmentid,
                                      String activePrincipalPeople,String activeContext) {
        ResultUtil result = new ResultUtil();
        if(startTime==null){
            result.setMsg("活动时间开始时间不能为空");
            result.setSuccess(false);
            return result.getResult();
        }
        if(activeType==null){
            result.setMsg("请传入活动类型");
            result.setSuccess(false);
            return result.getResult();
        }
        PScoreDetail detail = scoreDetailService.selectByPrimaryKey(activeType);
        if(detail==null){
            result.setMsg("活动类型找不到！");
            result.setSuccess(false);
            return result.getResult();
        }
        PActive active = new PActive();
        active.setStartTime(new Date(startTime));
        if(endTime!=null){
            active.setEndTime(new Date(endTime));
        }
        active.setActiveType(detail.getId());
        active.setActiveProjectId(detail.getProjectId());
        active.setActiveStatus(activeStatus);
        active.setActiveName(activeName);
        active.setActivePace(activePace);
        active.setActiveCreatePeople(activeCreatePeople);
        active.setDepartmentid(departmentid);
        active.setActivePrincipalPeople(activePrincipalPeople);
        active.setActiveContext(activeContext);
        active.setCreateTime(new Date());
        Integer id = pActiveService.insert(active);
        result.setData(id);
        result.setSuccess(true);
        result.setMsg("创建成功！");
        return result.getResult();
    }

    /**
     * 到场签名活动
     * @param activeId
     * @param userId
     * @return
     */
    @RequestMapping(value="/approved",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> approved(Integer activeId,Integer userId){
        ResultUtil result = new ResultUtil();
        PActive pActive = pActiveService.selectByPrimaryKey(activeId);
        if(pActive==null){
            result.setMsg("活动不存在！");
            result.setSuccess(false);
            return result.getResult();
        }
        if(pUserService.selectByPrimaryKey(userId)==null){
            result.setMsg("用户不存在！");
            result.setSuccess(false);
            return result.getResult();
        }
        PActiveParticipateExample example = new PActiveParticipateExample();
        PActiveParticipateExample.Criteria ct = example.createCriteria();
        ct.andUserIdEqualTo(userId);
        ct.andActiveIdEqualTo(activeId);
        List<PActiveParticipate> list = activeParticipateService.selectByExample(example);
        if(list!=null){
            if(list.size()==0){
                result.setMsg("请先报名");
                result.setSuccess(false);
                return result.getResult();
            }
            PActiveParticipate participate = list.get(0);
            if(Integer.valueOf(1).equals(participate.getStatus())){
                result.setMsg("请勿重复签到！");
                result.setSuccess(false);
                return result.getResult();
            }
            if(Integer.valueOf(2).equals(participate.getStatus())){
                result.setMsg("不允许签到！");
                result.setSuccess(false);
                return result.getResult();
            }
            participate.setStatus(1);
            activeParticipateService.updateByPrimaryKeySelective(participate);


            //签到成功后加积分
            PScoreParty pScoreParty = new PScoreParty();
            pScoreParty.setDetailId(pActive.getActiveType());
            pScoreParty.setUserId(userId);
            pScoreParty.setAddId(pActive.getActiveCreatePeople());
            if (pScoreParty.getDetailId() == null || pScoreParty.getUserId() == null || pScoreParty.getAdderId() == null){
                result.setSuccess(false);
                result.setMsg("请求加分参数不完整");
                return result.getResult();
            }
            if(pScorePartyService.updateScanCode(pScoreParty)>0){
                result.setSuccess(true);
                result.setMsg("签到成功,积分已发放");
                return result.getResult();
            }
            result.setSuccess(true);
            result.setMsg("签到积分已满或已发");
        }else{
            result.setMsg("请先报名");
            result.setSuccess(false);
        }
        return result.getResult();
    }

    /**
     * 报名活动
     * @param activeId
     * @param userId
     * @return
     */
    @RequestMapping(value="/participate",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> participate(Integer activeId,Integer userId){
        ResultUtil result = new ResultUtil();
        if(pActiveService.selectByPrimaryKey(activeId)==null){
            result.setMsg("活动不存在！");
            result.setSuccess(false);
            return result.getResult();
        }
        if(pUserService.selectByPrimaryKey(userId)==null){
            result.setMsg("用户不存在！");
            result.setSuccess(false);
            return result.getResult();
        }
        PActiveParticipateExample example = new PActiveParticipateExample();
        PActiveParticipateExample.Criteria ct = example.createCriteria();
        ct.andUserIdEqualTo(userId);
        ct.andActiveIdEqualTo(activeId);
        if(activeParticipateService.selectByExample(example).size()>0){
            result.setMsg("请勿重复报名");
            result.setSuccess(false);
            return result.getResult();
        }
        PActiveParticipate participate = new PActiveParticipate();
        participate.setCreateTime(new Date());
        participate.setUserId(userId);
        participate.setActiveId(activeId);
        participate.setStatus(0);
        activeParticipateService.insert(participate);

        result.setMsg("报名完成");
        result.setSuccess(true);

        return result.getResult();
    }

    /**
     * 查询部门活动（all 不传已经开始了）
     * @param departmentid
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getRunningActive",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRunningActive(Integer departmentid,Integer pageNum, Integer pageSize,@RequestParam(required=false)String all){
        ResultUtil result = new ResultUtil();
        PActiveExample example = new PActiveExample();
        PActiveExample.Criteria ct = example.createCriteria();
        ct.andActiveStatusEqualTo(1);
        if(departmentid!=null) ct.andDepartmentidEqualTo(departmentid);
        if(all!=null && all.equals("Y")){
            ct.andStartTimeLessThanOrEqualTo(new Date());
        }
        if (departmentid != null) {
            example.createCriteria().andDepartmentidEqualTo(departmentid);
        }
        PageHelper.startPage(pageNum, pageSize,true);
        List<PActive> pActiveList = pActiveService.selectByExample(example);
        List<JSONObject> list = new ArrayList<>();
        for (PActive active:pActiveList){
            JSONObject json = JSON.parseObject(JSON.toJSONString(active));
            PPartymember createUser = pPartymemberService.selectByUserId(active.getActiveCreatePeople());
            if(createUser!=null){
                json.put("activeCreatePeopleName", createUser.getName());
            }
            PActivePictureExample picExample = new PActivePictureExample();
            PActivePictureExample.Criteria picCt = picExample.createCriteria();
            picCt.andActiveIdEqualTo(active.getId());
//            PageHelper.startPage(1, 3,true);
            List<PActivePicture> picActiveList = pPictureService.selectActivePictures(picExample);
            json.put("pictures", picActiveList);
            list.add(json);
        }
        JSONArray array = new JSONArray();
        array.addAll(pActiveList);
        PageInfo<JSONObject> pageInfo=new PageInfo<JSONObject>(list);
        result.setSuccess(true);
        result.setData(pageInfo);
        return result.getResult();
    }


    //查询已完成（组织生活）的活动
    @RequestMapping(value="/getAlreadyActive",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAlreadyActive(Integer departmentid,Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PActiveExample example = new PActiveExample();
        PActiveExample.Criteria ct = example.createCriteria();
        ct.andActiveProjectIdEqualTo(2);
        ct.andActiveStatusEqualTo(1);
        ct.andEndTimeLessThanOrEqualTo(new Date());
        if (departmentid != null) {
            example.createCriteria().andDepartmentidEqualTo(departmentid);
        }
        PageHelper.startPage(pageNum, pageSize,true);
        List<PActive> pActiveList = pActiveService.selectByExample(example);
        List<JSONObject> list = new ArrayList<>();
        for (PActive active:pActiveList){
            JSONObject json = JSON.parseObject(JSON.toJSONString(active));
            PPartymember createUser = pPartymemberService.selectByUserId(active.getActiveCreatePeople());
            if(createUser!=null){
                json.put("activeCreatePeopleName", createUser.getName());
            }
            PActivePictureExample picExample = new PActivePictureExample();
            PActivePictureExample.Criteria picCt = picExample.createCriteria();
            picCt.andActiveIdEqualTo(active.getId());
//            PageHelper.startPage(1, 3,true);
            List<PActivePicture> picActiveList = pPictureService.selectActivePictures(picExample);
            json.put("pictures", picActiveList);
            list.add(json);
        }
        JSONArray array = new JSONArray();
        array.addAll(pActiveList);
        PageInfo<JSONObject> pageInfo=new PageInfo<JSONObject>(list);
        result.setSuccess(true);
        result.setData(pageInfo);
        return result.getResult();
    }

    /**
     * 查询活动能看到 自己报没报名的
     * @param userId 用户ID
     * @param departmentid
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getParticipateActive",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getParticipateActive(Integer userId,Integer departmentid,Integer pageNum, Integer pageSize,@RequestParam(required=false)String all){
        ResultUtil result = new ResultUtil();
        PActiveExample example = new PActiveExample();
        PActiveExample.Criteria ct = example.createCriteria();
        ct.andActiveStatusEqualTo(1);

        if(all!=null && all.equals("Y")){
            ct.andStartTimeGreaterThan(new Date());
        }
        if (departmentid != null) {
            ct.andDepartmentidEqualTo(departmentid);
        }
        PageHelper.startPage(pageNum, pageSize,true);
        List<PActive> pActiveList = pActiveService.selectByExample(example);
        List<JSONObject> list = new ArrayList<>();
        for (PActive active:pActiveList){
            JSONObject json = JSON.parseObject(JSON.toJSONString(active));
            PPartymember createUser = pPartymemberService.selectByUserId(active.getActiveCreatePeople());
            if(createUser!=null){
                json.put("activeCreatePeopleName", createUser.getName());
            }
            json.put("signupstatus", hasParticipate(active.getId(), userId)?1:2);
            PActivePictureExample picExample = new PActivePictureExample();
            PActivePictureExample.Criteria picCt = picExample.createCriteria();
            picCt.andActiveIdEqualTo(active.getId());



//            PageHelper.startPage(1, 3,true);
            List<PActivePicture> picActiveList = pPictureService.selectActivePictures(picExample);
            json.put("pictures", picActiveList);
            list.add(json);
        }
        JSONArray array = new JSONArray();
        array.addAll(pActiveList);
        PageInfo<JSONObject> pageInfo=new PageInfo<JSONObject>(list);
        result.setSuccess(true);
        result.setData(pageInfo);
        return result.getResult();
    }


    //查看自己参与的活动
    @RequestMapping(value="/getEnjoyActiveByUserId",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEnjoyActiveByUserId(Integer userId,Integer departmentid,@RequestParam(required=false)String all){
        ResultUtil result = new ResultUtil();
        PActiveExample example = new PActiveExample();
        PActiveExample.Criteria ct = example.createCriteria();
        ct.andActiveStatusEqualTo(1);
        if(all!=null && all.equals("Y")){
            ct.andStartTimeGreaterThan(new Date());
        }
        if (departmentid != null) {
            example.createCriteria().andDepartmentidEqualTo(departmentid);
        }
        List<PActive> pActiveList = pActiveService.selectByExample(example);
        List<JSONObject> list = new ArrayList<>();
        for (PActive active:pActiveList){
            JSONObject json = JSON.parseObject(JSON.toJSONString(active));
            PPartymember createUser = pPartymemberService.selectByUserId(active.getActiveCreatePeople());
            if(createUser!=null){
                json.put("activeCreatePeopleName", createUser.getName());
            }
            if(hasParticipate(active.getId(), userId)){

                PActiveParticipateExample participateExample = new PActiveParticipateExample();
                PActiveParticipateExample.Criteria ctp = participateExample.createCriteria();
                ctp.andActiveIdEqualTo(active.getId());
                ctp.andUserIdEqualTo(userId);
                ctp.andStatusEqualTo(1);

                List<PActiveParticipate> ppList =  activeParticipateService.selectByExample(participateExample);
                if(ppList!=null){

                    if(ppList.size()>0){

                        PActivePictureExample picExample = new PActivePictureExample();
                        PActivePictureExample.Criteria picCt = picExample.createCriteria();
                        picCt.andActiveIdEqualTo(active.getId());
//            PageHelper.startPage(1, 3,true);
                        List<PActivePicture> picActiveList = pPictureService.selectActivePictures(picExample);
                        json.put("pictures", picActiveList);
                        list.add(json);

                    }

                }

            }

        }
        result.setSuccess(true);
        result.setData(list);
        return result.getResult();
    }

    /**
     * 判断是否已经报名的活动
     * @param activeId
     * @param userId
     * @return
     */
    private boolean hasParticipate(Integer activeId, Integer userId) {
        PActiveParticipateExample example = new PActiveParticipateExample();
        PActiveParticipateExample.Criteria ct = example.createCriteria();
        ct.andUserIdEqualTo(userId);
        ct.andActiveIdEqualTo(activeId);
        if(activeParticipateService.selectByExample(example).size()>0){
            return true;
        }
        return false;
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize);
        List<PActive> pActiveList = pActiveService.selectByExample(new PActiveExample());
        PageInfo<PActive> p=new PageInfo<PActive>(pActiveList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer activeid){
        ResultUtil result = new ResultUtil();
        PActiveExample example = new PActiveExample();
        if(pActiveService.deleteByPrimaryKey(activeid)>0){
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
    public Map<String, Object> updateById(PActive pActive){
        ResultUtil result = new ResultUtil();
        if(pActiveService.updateByPrimaryKey(pActive)>0){
            result.setSuccess(true);
            result.setMsg("修改成功");
        }else{
            result.setSuccess(false);
            result.setMsg("修改失败");
        }
        return result.getResult();
    }

    /**
     * 查询活动详情
     * @param activeId
     * @return
     */
    @RequestMapping(value="/queryById",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> queryById(Integer activeId){
        ResultUtil result = new ResultUtil();
        PActive pActive = pActiveService.selectByPrimaryKey(activeId);
        JSONObject json = JSON.parseObject(JSON.toJSONString(pActive));
        PPartymember createUser = pPartymemberService.selectByUserId(pActive.getActiveCreatePeople());
        if(createUser!=null){
            json.put("activeCreatePeopleName", createUser.getName());
        }
        PActiveParticipateExample pActiveParticipateExample = new PActiveParticipateExample();
        pActiveParticipateExample.createCriteria().andActiveIdEqualTo(activeId);
        List<PActiveParticipate> participateList = activeParticipateService.selectByExample(pActiveParticipateExample);

        List<Integer> inList = new ArrayList<>();
        List<Integer> outList = new ArrayList<>();
        for (PActiveParticipate item:participateList){
            if (Integer.valueOf(1).equals(item.getStatus())) {
                inList.add(item.getUserId());
            }else if(Integer.valueOf(0).equals(item.getStatus())){
                outList.add(item.getUserId());
            }
        }
        List<PPartymember> inUserList = new ArrayList<>();

        List<PPartymember> outUserList = new ArrayList<>();
        if(inList.size()>0){
            PPartymemberExample inUserExample = new PPartymemberExample();
            inUserExample.createCriteria().andUseridIn(inList);
            inUserList.addAll(pPartymemberService.selectByExample(inUserExample));
        }
        if(outList.size()>0){
            PPartymemberExample outUserExample = new PPartymemberExample();
            outUserExample.createCriteria().andUseridIn(outList);
            outUserList.addAll(pPartymemberService.selectByExample(outUserExample));
        }
        json.put("participate", inUserList);
        json.put("notParticipate", outUserList);

        result.setSuccess(true);
        result.setData(json);
        return result.getResult();
    }

    /**
     * 查询年度参与次数
     * @param userId
     * @return
     */
    @RequestMapping(value="/getParticipateCount",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getParticipateCount(Integer year,Integer userId,Integer activeType) {
        ResultUtil result = new ResultUtil();
        Date startTime = DateUtil.getYearFirst(year);
        Date endTime = DateUtil.getYearLast(year);
        int count = pActiveService.selectByActiveTypeAndUserParticipate(userId, activeType,startTime,endTime);
        result.setSuccess(true);
        result.setMsg("查询成功");
        result.setData(count);
        return result.getResult();
    }




    /**
     * 保存活动图片
     * @param activeId
     * @param pictureId
     * @return
     */
    @RequestMapping(value="/savePicture",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> savePicture(Integer activeId,Integer pictureId) {
        ResultUtil result = new ResultUtil();
        if(pActiveService.selectByPrimaryKey(activeId)==null){
            result.setMsg("活动不存在！");
            result.setSuccess(false);
            return result.getResult();
        }
        if(pPictureService.selectByPrimaryKey(pictureId)==null){
            result.setMsg("图片不存在！");
            result.setSuccess(false);
            return result.getResult();
        }
        PActivePicture activePicture = new PActivePicture();
        activePicture.setActiveId(activeId);
        activePicture.setPictureId(pictureId);
        int id = pActiveService.savePicture(activePicture);
        result.setSuccess(true);
        result.setMsg("保存成功");
        result.setData(id);
        return result.getResult();
    }

    /**
     * 查询活动图集
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getActivePictures",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getActivePictures(Integer activeId,Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PActivePictureExample example = new PActivePictureExample();
        PActivePictureExample.Criteria ct = example.createCriteria();
        ct.andActiveIdEqualTo(activeId);
        List<PActivePicture> pActivePictureList = pPictureService.selectActivePictures(example);
        result.setSuccess(true);
        result.setData(pActivePictureList);
        return result.getResult();
    }
    /**
     * 显示活动二维码
     * @return
     */
    @RequestMapping(value="/showQrCode",method= {RequestMethod.POST,RequestMethod.GET})
    public void showQrCode(Integer activeId,HttpServletResponse response){
        String content = "http://dj.dlbdata.cn/#/active/activeSign/"+activeId;
        BufferedImage image;
        try {
            image = genPic(content);
            response.setContentType("image/jpeg");
            // 设置页面不缓存
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            OutputStream out = response.getOutputStream();//取得响应输出流
            ImageIO.write(image, "JPEG", out);
            out.flush();
            out.close();
        }catch (Exception e){
            _log.error(e.getMessage(), e);
        }
    }

    private BufferedImage genPic(String content)throws Exception{
//        int qr_size = 400;
//        int qr_size = 213;
        int qr_size = 150;
        Object errorCorrectionLevel = ErrorCorrectionLevel.H;
        Map hints = new HashMap();
        hints.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel);
        // hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 1);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, qr_size, qr_size, hints);
        BufferedImage image = toBufferedImage(bitMatrix);
        return image;
    }

    private BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }
}
