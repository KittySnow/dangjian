package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PActiveDepartmentDao;
import cn.dlbdata.dangjian.admin.dao.model.PActiveDepartment;
import cn.dlbdata.dangjian.admin.dao.model.PActiveDepartmentExample;
import cn.dlbdata.dangjian.admin.service.PActiveDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PActiveDepartmentService")
public class PActiveDepartmentServiceImpl implements PActiveDepartmentService {

    private static Logger _log = LoggerFactory.getLogger(PActiveDepartmentServiceImpl.class);

    @Autowired
    PActiveDepartmentDao pActiveDepartmentDao;

    @Override
    public long countByExample(PActiveDepartmentExample example) {
        return pActiveDepartmentDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PActiveDepartmentExample example) {
        return pActiveDepartmentDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pActiveDepartmentDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PActiveDepartment pActiveDepartment) {
        pActiveDepartmentDao.insert(pActiveDepartment);
        return pActiveDepartment.getId();
    }
    
    @Override
    public int insertSelective(PActiveDepartment pActiveDepartment) {
        pActiveDepartmentDao.insertSelective(pActiveDepartment);
        return pActiveDepartment.getId();
    }
    
    @Override
    public List<PActiveDepartment> selectByExample(PActiveDepartmentExample example) {
        return pActiveDepartmentDao.selectByExample(example);
    }

    @Override
    public PActiveDepartment selectByPrimaryKey(Integer id) {
        return pActiveDepartmentDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PActiveDepartment pActiveDepartment, PActiveDepartmentExample example) {
        return pActiveDepartmentDao.updateByExampleSelective(pActiveDepartment,example);
    }

    @Override
    public int updateByExample(PActiveDepartment pActiveDepartment, PActiveDepartmentExample example) {
        return pActiveDepartmentDao.updateByExample(pActiveDepartment,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PActiveDepartment pActiveDepartment) {
        return pActiveDepartmentDao.updateByPrimaryKeySelective(pActiveDepartment);
    }

    @Override
    public int updateByPrimaryKey(PActiveDepartment pActiveDepartment) {
        return pActiveDepartmentDao.updateByPrimaryKey(pActiveDepartment);
    }

    @Override
    public void insertList(Integer[] departmentIds ,Integer activeId){
        pActiveDepartmentDao.insertList(departmentIds ,activeId);
    }
}