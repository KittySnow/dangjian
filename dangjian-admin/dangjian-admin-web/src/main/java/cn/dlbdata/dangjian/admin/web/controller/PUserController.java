package cn.dlbdata.dangjian.admin.web.controller;


import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import cn.dlbdata.dangjian.admin.service.PUserService;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

import static cn.dlbdata.dangjian.admin.service.util.DangjianUtil.getMD5;

@Controller
@RequestMapping("/puser")
public class PUserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PUserController.class);
	private final static String DEFAULT_PASSWORD	= "12345678";//用户的默认登录密码。
	private final static String INSERT_ERROR_MSG	= "增加新用户时发生异常，本操作失败，请联系管理员！";
	private final static String INSERT_SUCCESS_MSG	= "增加新用户成功！";
	
    @Autowired
    private PUserService puserService;
    

    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PUser pUser){
        ResultUtil result = new ResultUtil();
        pUser.setPassword(getMD5(DEFAULT_PASSWORD));
        int insertedUserId= 0;
        try	{
        	insertedUserId = puserService.insert(pUser);
            result.setData(insertedUserId);
            result.setSuccess(true);
            result.setMsg(INSERT_SUCCESS_MSG);
        } catch (Exception ex)	{
        	LOGGER.error(ex.getMessage());
            result.setSuccess(false);
            result.setMsg(INSERT_ERROR_MSG);
        }
        
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PUser> puserList = puserService.selectByExample(new PUserExample());
        result.setSuccess(true);
        result.setData(puserList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PUser> puserList = puserService.selectByExample(new PUserExample());
        PageInfo<PUser> p=new PageInfo<PUser>(puserList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/allList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> allList(Integer pageNum, Integer pageSize,String searchText){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        if(searchText == null){
            searchText ="";
        }
        List<PUser> puserList = puserService.selectAll("%"+searchText+"%");
        PageInfo<PUser> p=new PageInfo<PUser>(puserList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method=RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer userid){
        ResultUtil result = new ResultUtil();
        //PUserExample example = new PUserExample();
        if(puserService.deleteByPrimaryKey(userid)>0){
            result.setSuccess(true);
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
            result.setSuccess(false);
        }
        return result.getResult();
    }


    @RequestMapping(value="/updateById",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateById(PUser pUser){
        ResultUtil result = new ResultUtil();
        if(puserService.updateByPrimaryKeySelective(pUser)>0){
            result.setSuccess(true);
            result.setMsg("修改成功");
        }else{
            result.setMsg("修改失败");
            result.setSuccess(false);
        }
        return result.getResult();
    }

    @RequestMapping(value="/queryById",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryById(Integer userid){
        ResultUtil result = new ResultUtil();
        PUser puser = puserService.selectByPrimaryKey(userid);
        result.setSuccess(true);
        result.setData(puser);
        return result.getResult();
    }

}