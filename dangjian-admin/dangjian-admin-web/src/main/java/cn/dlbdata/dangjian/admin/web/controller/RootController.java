package cn.dlbdata.dangjian.admin.web.controller;


import cn.dlbdata.dangjian.admin.dao.model.PDepartment;
import cn.dlbdata.dangjian.admin.dao.model.PDepartmentExample;
import cn.dlbdata.dangjian.admin.service.PDepartmentService;
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
@RequestMapping("/")
public class RootController {

    @RequestMapping(value="/")
    public String index(){
        return "index";
    }
}