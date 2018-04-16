package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PActivePicture;
import cn.dlbdata.dangjian.admin.dao.model.PActivePictureExample;
import cn.dlbdata.dangjian.admin.service.PActivePictureService;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pactivepicture")

public class PActivePictureController {

    @Autowired
    private PActivePictureService pActivePictureService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PActivePicture pActivePicture){
        ResultUtil result = new ResultUtil();
        int callbackId = pActivePictureService.insert(pActivePicture);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PActivePicture> pActivePictureList = pActivePictureService.selectByExample(new PActivePictureExample());
        result.setSuccess(true);
        result.setData(pActivePictureList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PActivePicture> pActivePictureList = pActivePictureService.selectByExample(new PActivePictureExample());
        PageInfo<PActivePicture> p=new PageInfo<PActivePicture>(pActivePictureList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        PActivePictureExample example = new PActivePictureExample();
        if(pActivePictureService.deleteByPrimaryKey(id)>0){
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
    public Map<String, Object> updateById(PActivePicture pActivePicture){
        ResultUtil result = new ResultUtil();
        if(pActivePictureService.updateByPrimaryKey(pActivePicture)>0){
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
        PActivePicture pActivePicture = pActivePictureService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pActivePicture);
        return result.getResult();
    }
}