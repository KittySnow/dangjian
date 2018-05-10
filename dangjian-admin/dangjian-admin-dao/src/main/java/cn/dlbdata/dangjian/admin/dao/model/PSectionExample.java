package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.dlbdata.dangjian.admin.dao.model.PDepartmentExample.Criteria;

public class PSectionExample implements Serializable {
	 protected String orderByClause;

	    protected boolean distinct;

	    protected List<Criteria> oredCriteria;

	    private static final long serialVersionUID = 1L;
	    
	    public PSectionExample() {
	        oredCriteria = new ArrayList<Criteria>();
	    }

	    
}
