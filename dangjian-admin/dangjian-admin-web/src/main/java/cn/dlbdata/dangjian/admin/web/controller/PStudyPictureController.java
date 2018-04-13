package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PStudyPicture;
import cn.dlbdata.dangjian.admin.dao.model.PStudyPictureExample;
import cn.dlbdata.dangjian.admin.service.PStudyPictureService;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Array;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pstudypicture")

public class PStudyPictureController {

    @Autowired
    private PStudyPictureService pStudyPictureService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PStudyPicture pStudyPicture) {
        ResultUtil result = new ResultUtil();
        int callbackId = pStudyPictureService.insert(pStudyPicture);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize) {
        ResultUtil result = new ResultUtil();
        List<PStudyPicture> pStudyPictureList = pStudyPictureService.selectByExample(new PStudyPictureExample());
        result.setSuccess(true);
        result.setData(pStudyPictureList);
        return result.getResult();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize) {
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize, true);
        List<PStudyPicture> pStudyPictureList = pStudyPictureService.selectByExample(new PStudyPictureExample());
        PageInfo<PStudyPicture> p = new PageInfo<PStudyPicture>(pStudyPictureList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer id) {
        ResultUtil result = new ResultUtil();
        PStudyPictureExample example = new PStudyPictureExample();
        if (pStudyPictureService.deleteByPrimaryKey(id) > 0) {
            result.setSuccess(true);
            result.setMsg("删除成功");
        } else {
            result.setMsg("删除失败");
            result.setSuccess(false);
        }
        return result.getResult();
    }


    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateById(PStudyPicture pStudyPicture) {
        ResultUtil result = new ResultUtil();
        if (pStudyPictureService.updateByPrimaryKey(pStudyPicture) > 0) {
            result.setSuccess(true);
            result.setMsg("修改成功");
        } else {
            result.setSuccess(false);
            result.setMsg("修改失败");
        }
        return result.getResult();
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryById(Integer id) {
        ResultUtil result = new ResultUtil();
        PStudyPicture pStudyPicture = pStudyPictureService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pStudyPicture);
        return result.getResult();
    }

    @RequestMapping(value = "/insertList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> insertList(String picids, Integer studyId) {
        ResultUtil result = new ResultUtil();

        String[] picIds = picids.split(",");
        Integer[] pds = new Integer[picIds.length];

        if (picIds.length != 0) {
            for (int i = 0; i < picIds.length; i++) {
                pds[i] = Integer.parseInt(picIds[i]);
            }
        }

        pStudyPictureService.insertList(pds, studyId);

        result.setSuccess(true);
        result.setMsg("图片上传成功");
        return result.getResult();

    }


}