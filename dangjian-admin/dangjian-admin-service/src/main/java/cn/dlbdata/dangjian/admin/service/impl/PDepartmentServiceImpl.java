package cn.dlbdata.dangjian.admin.service.impl;



import cn.dlbdata.dangjian.admin.dao.mapper.PDepartmentDao;
import cn.dlbdata.dangjian.admin.dao.model.PDepartment;
import cn.dlbdata.dangjian.admin.dao.model.PDepartmentExample;
import cn.dlbdata.dangjian.admin.service.PDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("PDepartmentService")
public class PDepartmentServiceImpl implements PDepartmentService {

    private static Logger _log = LoggerFactory.getLogger(PDepartmentServiceImpl.class);

    @Resource
    PDepartmentDao pDepartmentDao;

    @Override
    public long countByExample(PDepartmentExample example) {
        return pDepartmentDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PDepartmentExample example) {
        return pDepartmentDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer departmentId) {
        return pDepartmentDao.deleteByPrimaryKey(departmentId);
    }
    
    @Override
    public int insert(PDepartment pDepartment) {
        pDepartmentDao.insert(pDepartment);
        return pDepartment.getDepartmentid();
    }
    
    @Override
    public int insertSelective(PDepartment pDepartment) {
        pDepartmentDao.insertSelective(pDepartment);
        return pDepartment.getDepartmentid();
    }
    
    @Override
    public List<PDepartment> selectByExample(PDepartmentExample example) {
        return pDepartmentDao.selectByExample(example);
    }

    @Override
    public PDepartment selectByPrimaryKey(Integer departmentId) {
        return pDepartmentDao.selectByPrimaryKey(departmentId);
    }

    @Override
    public int updateByExampleSelective(PDepartment pDepartment, PDepartmentExample example) {
        return pDepartmentDao.updateByExampleSelective(pDepartment,example);
    }

    @Override
    public int updateByExample(PDepartment pDepartment, PDepartmentExample example) {
        return pDepartmentDao.updateByExample(pDepartment,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PDepartment pDepartment) {
        return pDepartmentDao.updateByPrimaryKeySelective(pDepartment);
    }

    @Override
    public int updateByPrimaryKey(PDepartment pDepartment) {
        return pDepartmentDao.updateByPrimaryKey(pDepartment);
    }

}