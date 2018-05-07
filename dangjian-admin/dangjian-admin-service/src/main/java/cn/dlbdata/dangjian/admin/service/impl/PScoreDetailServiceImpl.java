package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PScoreDetailDao;
import cn.dlbdata.dangjian.admin.dao.model.PScoreDetail;
import cn.dlbdata.dangjian.admin.dao.model.PScoreDetailExample;
import cn.dlbdata.dangjian.admin.service.PScoreDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("PScoreDetailService")
public class PScoreDetailServiceImpl implements PScoreDetailService {

    private static Logger _log = LoggerFactory.getLogger(PScoreDetailServiceImpl.class);

    @Autowired
    PScoreDetailDao pScoreDetailDao;

    @Override
    public long countByExample(PScoreDetailExample example) {
        return pScoreDetailDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PScoreDetailExample example) {
        return pScoreDetailDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pScoreDetailDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PScoreDetail pScoreDetail) {
        pScoreDetailDao.insert(pScoreDetail);
        return pScoreDetail.getId();
    }
    
    @Override
    public int insertSelective(PScoreDetail pScoreDetail) {
        pScoreDetailDao.insertSelective(pScoreDetail);
        return pScoreDetail.getId();
    }
    
    @Override
    public List<PScoreDetail> selectByExample(PScoreDetailExample example) {
        return pScoreDetailDao.selectByExample(example);
    }

    @Override
    public PScoreDetail selectByPrimaryKey(Integer id) {
        return pScoreDetailDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PScoreDetail pScoreDetail, PScoreDetailExample example) {
        return pScoreDetailDao.updateByExampleSelective(pScoreDetail,example);
    }

    @Override
    public int updateByExample(PScoreDetail pScoreDetail, PScoreDetailExample example) {
        return pScoreDetailDao.updateByExample(pScoreDetail,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PScoreDetail pScoreDetail) {
        return pScoreDetailDao.updateByPrimaryKeySelective(pScoreDetail);
    }

    @Override
    public int updateByPrimaryKey(PScoreDetail pScoreDetail) {
        return pScoreDetailDao.updateByPrimaryKey(pScoreDetail);
    }

    @Override
    public List<Map<String, Object>> selectTodoList(Integer userId) {
        return pScoreDetailDao.selectTodoList(userId);
    }

	@Override
	public int selectTodoListCount(Integer userId) {
		
		return pScoreDetailDao.selectTodoListCount(userId);
	}
}