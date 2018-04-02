package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PScorelevelDao;
import cn.dlbdata.dangjian.admin.dao.model.PScorelevel;
import cn.dlbdata.dangjian.admin.dao.model.PScorelevelExample;
import cn.dlbdata.dangjian.admin.service.PScorelevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("PScorelevelService")
public class PScorelevelServiceImpl implements PScorelevelService {

    private static Logger _log = LoggerFactory.getLogger(PScorelevelServiceImpl.class);

    @Resource
    PScorelevelDao pScorelevelDao;

    @Override
    public long countByExample(PScorelevelExample example) {
        return pScorelevelDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PScorelevelExample example) {
        return pScorelevelDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer scoreid) {
        return pScorelevelDao.deleteByPrimaryKey(scoreid);
    }
    
    @Override
    public int insert(PScorelevel pScorelevel) {
        pScorelevelDao.insert(pScorelevel);
        return pScorelevel.getScoreid();
    }
    
    @Override
    public int insertSelective(PScorelevel pScorelevel) {
        pScorelevelDao.insertSelective(pScorelevel);
        return pScorelevel.getScoreid();
    }
    
    @Override
    public List<PScorelevel> selectByExample(PScorelevelExample example) {
        return pScorelevelDao.selectByExample(example);
    }

    @Override
    public PScorelevel selectByPrimaryKey(Integer scoreid) {
        return pScorelevelDao.selectByPrimaryKey(scoreid);
    }

    @Override
    public int updateByExampleSelective(PScorelevel pScorelevel, PScorelevelExample example) {
        return pScorelevelDao.updateByExampleSelective(pScorelevel,example);
    }

    @Override
    public int updateByExample(PScorelevel pScorelevel, PScorelevelExample example) {
        return pScorelevelDao.updateByExample(pScorelevel,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PScorelevel pScorelevel) {
        return pScorelevelDao.updateByPrimaryKeySelective(pScorelevel);
    }

    @Override
    public int updateByPrimaryKey(PScorelevel pScorelevel) {
        return pScorelevelDao.updateByPrimaryKey(pScorelevel);
    }

}