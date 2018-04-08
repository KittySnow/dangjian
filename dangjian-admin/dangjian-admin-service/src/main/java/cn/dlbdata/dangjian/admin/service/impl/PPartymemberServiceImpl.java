package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PPartymemberDao;
import cn.dlbdata.dangjian.admin.dao.mapper.PUserDao;
import cn.dlbdata.dangjian.admin.dao.model.PPartymember;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberExample;
import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import cn.dlbdata.dangjian.admin.service.PPartymemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("PPartymemberService")
public class PPartymemberServiceImpl implements PPartymemberService {

    private static Logger _log = LoggerFactory.getLogger(PPartymemberServiceImpl.class);

    @Autowired
    PPartymemberDao pPartymemberDao;

    @Resource
    PUserDao pUserDao;

    @Override
    public long countByExample(PPartymemberExample example) {
        return pPartymemberDao.countByExample(example);
    }

    @Override
    public long countUser() {
        return pPartymemberDao.countUser();
    }
    
    @Override
    public int deleteByExample(PPartymemberExample example) {
        return pPartymemberDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pPartymemberDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PPartymember pPartymember) {
        pPartymemberDao.insert(pPartymember);
        return pPartymember.getId();
    }
    
    @Override
    public int insertSelective(PPartymember pPartymember) {
        pPartymemberDao.insertSelective(pPartymember);
        return pPartymember.getId();
    }
    
    @Override
    public List<PPartymember> selectByExample(PPartymemberExample example) {
        return pPartymemberDao.selectByExample(example);
    }

    @Override
    public PPartymember selectByPrimaryKey(Integer id) {
        return pPartymemberDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PPartymember pPartymember, PPartymemberExample example) {
        return pPartymemberDao.updateByExampleSelective(pPartymember,example);
    }

    @Override
    public int updateByExample(PPartymember pPartymember, PPartymemberExample example) {
        return pPartymemberDao.updateByExample(pPartymember,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PPartymember pPartymember) {
        return pPartymemberDao.updateByPrimaryKeySelective(pPartymember);
    }

    @Override
    public int updateByPrimaryKey(PPartymember pPartymember) {
        return pPartymemberDao.updateByPrimaryKey(pPartymember);
    }

    @Override
    public PPartymember selectByUserId(Integer userid){
        PPartymemberExample pPartymemberExample = new PPartymemberExample();
        PPartymemberExample.Criteria criteria =  pPartymemberExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<PPartymember> pPartymemberList = this.selectByExample(pPartymemberExample);
        if(pPartymemberList!=null){
            return pPartymemberList.get(0);
        }else{
            return null;
        }
    }

    //查找书记
    public PPartymember selectBranchByDepartmentId(Integer departmentid){

        PUserExample pUserExample = new PUserExample();
        PUserExample.Criteria ct = pUserExample.createCriteria();
        ct.andRoleidEqualTo(3);
        ct.andDepartmentidEqualTo(departmentid);
        PUser pUser = pUserDao.selectByExample(pUserExample).get(0);

        PPartymemberExample pPartymemberExample = new PPartymemberExample();
        PPartymemberExample.Criteria criteria =  pPartymemberExample.createCriteria();
        criteria.andUseridEqualTo(pUser.getUserid());
        List<PPartymember> pPartymemberList = this.selectByExample(pPartymemberExample);
        if(pPartymemberList!=null){
            return pPartymemberList.get(0);
        }else{
            return null;
        }
    }


    //查找片区书记
    public PPartymember selectBranchByDepartmentId(){

        PUserExample pUserExample = new PUserExample();
        PUserExample.Criteria ct = pUserExample.createCriteria();
        ct.andRoleidEqualTo(2);
        PUser pUser = pUserDao.selectByExample(pUserExample).get(0);

        PPartymemberExample pPartymemberExample = new PPartymemberExample();
        PPartymemberExample.Criteria criteria =  pPartymemberExample.createCriteria();
        criteria.andUseridEqualTo(pUser.getUserid());
        List<PPartymember> pPartymemberList = this.selectByExample(pPartymemberExample);
        if(pPartymemberList!=null){
            return pPartymemberList.get(0);
        }else{
            return null;
        }
    }
}