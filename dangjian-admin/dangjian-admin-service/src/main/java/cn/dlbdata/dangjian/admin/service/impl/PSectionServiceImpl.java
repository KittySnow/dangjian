package cn.dlbdata.dangjian.admin.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.dlbdata.dangjian.admin.dao.mapper.PSectionDao;
import cn.dlbdata.dangjian.admin.dao.model.PSection;
import cn.dlbdata.dangjian.admin.dao.model.PSectionExample;
import cn.dlbdata.dangjian.admin.service.PSectionService;


@Service("PSectionService")
public class PSectionServiceImpl implements PSectionService {

    private static Logger _log = LoggerFactory.getLogger(PSectionServiceImpl.class);
    
    @Resource
    PSectionDao pSectionDao;
    
	@Override
	public long countByExample(PSectionExample example) {
		return pSectionDao.countByExample(example);
	}

	@Override
	public int deleteByExample(PSectionExample example) {
		return pSectionDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return pSectionDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PSection record) {
		return pSectionDao.insert(record);
	}

	@Override
	public int insertSelective(PSection record) {
		return pSectionDao.insertSelective(record);
	}

	@Override
	public List<PSection> selectByExample(PSectionExample example) {
		return pSectionDao.selectByExample(example);
	}

	@Override
	public PSection selectByPrimaryKey(Integer id) {
		return pSectionDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(PSection record, PSectionExample example) {
		return pSectionDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(PSection record, PSectionExample example) {
		return pSectionDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(PSection record) {
		return pSectionDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PSection record) {
		return pSectionDao.updateByPrimaryKey(record);
	}

   
}