package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PSpaceExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public PSpaceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSpaceidIsNull() {
            addCriterion("spaceid is null");
            return (Criteria) this;
        }

        public Criteria andSpaceidIsNotNull() {
            addCriterion("spaceid is not null");
            return (Criteria) this;
        }

        public Criteria andSpaceidEqualTo(Integer value) {
            addCriterion("spaceid =", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidNotEqualTo(Integer value) {
            addCriterion("spaceid <>", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidGreaterThan(Integer value) {
            addCriterion("spaceid >", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("spaceid >=", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidLessThan(Integer value) {
            addCriterion("spaceid <", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidLessThanOrEqualTo(Integer value) {
            addCriterion("spaceid <=", value, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidIn(List<Integer> values) {
            addCriterion("spaceid in", values, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidNotIn(List<Integer> values) {
            addCriterion("spaceid not in", values, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidBetween(Integer value1, Integer value2) {
            addCriterion("spaceid between", value1, value2, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpaceidNotBetween(Integer value1, Integer value2) {
            addCriterion("spaceid not between", value1, value2, "spaceid");
            return (Criteria) this;
        }

        public Criteria andSpacenameIsNull() {
            addCriterion("spacename is null");
            return (Criteria) this;
        }

        public Criteria andSpacenameIsNotNull() {
            addCriterion("spacename is not null");
            return (Criteria) this;
        }

        public Criteria andSpacenameEqualTo(String value) {
            addCriterion("spacename =", value, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameNotEqualTo(String value) {
            addCriterion("spacename <>", value, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameGreaterThan(String value) {
            addCriterion("spacename >", value, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameGreaterThanOrEqualTo(String value) {
            addCriterion("spacename >=", value, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameLessThan(String value) {
            addCriterion("spacename <", value, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameLessThanOrEqualTo(String value) {
            addCriterion("spacename <=", value, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameLike(String value) {
            addCriterion("spacename like", value, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameNotLike(String value) {
            addCriterion("spacename not like", value, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameIn(List<String> values) {
            addCriterion("spacename in", values, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameNotIn(List<String> values) {
            addCriterion("spacename not in", values, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameBetween(String value1, String value2) {
            addCriterion("spacename between", value1, value2, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacenameNotBetween(String value1, String value2) {
            addCriterion("spacename not between", value1, value2, "spacename");
            return (Criteria) this;
        }

        public Criteria andSpacecostIsNull() {
            addCriterion("spacecost is null");
            return (Criteria) this;
        }

        public Criteria andSpacecostIsNotNull() {
            addCriterion("spacecost is not null");
            return (Criteria) this;
        }

        public Criteria andSpacecostEqualTo(Double value) {
            addCriterion("spacecost =", value, "spacecost");
            return (Criteria) this;
        }

        public Criteria andSpacecostNotEqualTo(Double value) {
            addCriterion("spacecost <>", value, "spacecost");
            return (Criteria) this;
        }

        public Criteria andSpacecostGreaterThan(Double value) {
            addCriterion("spacecost >", value, "spacecost");
            return (Criteria) this;
        }

        public Criteria andSpacecostGreaterThanOrEqualTo(Double value) {
            addCriterion("spacecost >=", value, "spacecost");
            return (Criteria) this;
        }

        public Criteria andSpacecostLessThan(Double value) {
            addCriterion("spacecost <", value, "spacecost");
            return (Criteria) this;
        }

        public Criteria andSpacecostLessThanOrEqualTo(Double value) {
            addCriterion("spacecost <=", value, "spacecost");
            return (Criteria) this;
        }

        public Criteria andSpacecostIn(List<Double> values) {
            addCriterion("spacecost in", values, "spacecost");
            return (Criteria) this;
        }

        public Criteria andSpacecostNotIn(List<Double> values) {
            addCriterion("spacecost not in", values, "spacecost");
            return (Criteria) this;
        }

        public Criteria andSpacecostBetween(Double value1, Double value2) {
            addCriterion("spacecost between", value1, value2, "spacecost");
            return (Criteria) this;
        }

        public Criteria andSpacecostNotBetween(Double value1, Double value2) {
            addCriterion("spacecost not between", value1, value2, "spacecost");
            return (Criteria) this;
        }

        public Criteria andSpacesquareIsNull() {
            addCriterion("spacesquare is null");
            return (Criteria) this;
        }

        public Criteria andSpacesquareIsNotNull() {
            addCriterion("spacesquare is not null");
            return (Criteria) this;
        }

        public Criteria andSpacesquareEqualTo(Double value) {
            addCriterion("spacesquare =", value, "spacesquare");
            return (Criteria) this;
        }

        public Criteria andSpacesquareNotEqualTo(Double value) {
            addCriterion("spacesquare <>", value, "spacesquare");
            return (Criteria) this;
        }

        public Criteria andSpacesquareGreaterThan(Double value) {
            addCriterion("spacesquare >", value, "spacesquare");
            return (Criteria) this;
        }

        public Criteria andSpacesquareGreaterThanOrEqualTo(Double value) {
            addCriterion("spacesquare >=", value, "spacesquare");
            return (Criteria) this;
        }

        public Criteria andSpacesquareLessThan(Double value) {
            addCriterion("spacesquare <", value, "spacesquare");
            return (Criteria) this;
        }

        public Criteria andSpacesquareLessThanOrEqualTo(Double value) {
            addCriterion("spacesquare <=", value, "spacesquare");
            return (Criteria) this;
        }

        public Criteria andSpacesquareIn(List<Double> values) {
            addCriterion("spacesquare in", values, "spacesquare");
            return (Criteria) this;
        }

        public Criteria andSpacesquareNotIn(List<Double> values) {
            addCriterion("spacesquare not in", values, "spacesquare");
            return (Criteria) this;
        }

        public Criteria andSpacesquareBetween(Double value1, Double value2) {
            addCriterion("spacesquare between", value1, value2, "spacesquare");
            return (Criteria) this;
        }

        public Criteria andSpacesquareNotBetween(Double value1, Double value2) {
            addCriterion("spacesquare not between", value1, value2, "spacesquare");
            return (Criteria) this;
        }

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andToidIsNull() {
            addCriterion("toid is null");
            return (Criteria) this;
        }

        public Criteria andToidIsNotNull() {
            addCriterion("toid is not null");
            return (Criteria) this;
        }

        public Criteria andToidEqualTo(Long value) {
            addCriterion("toid =", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidNotEqualTo(Long value) {
            addCriterion("toid <>", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidGreaterThan(Long value) {
            addCriterion("toid >", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidGreaterThanOrEqualTo(Long value) {
            addCriterion("toid >=", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidLessThan(Long value) {
            addCriterion("toid <", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidLessThanOrEqualTo(Long value) {
            addCriterion("toid <=", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidIn(List<Long> values) {
            addCriterion("toid in", values, "toid");
            return (Criteria) this;
        }

        public Criteria andToidNotIn(List<Long> values) {
            addCriterion("toid not in", values, "toid");
            return (Criteria) this;
        }

        public Criteria andToidBetween(Long value1, Long value2) {
            addCriterion("toid between", value1, value2, "toid");
            return (Criteria) this;
        }

        public Criteria andToidNotBetween(Long value1, Long value2) {
            addCriterion("toid not between", value1, value2, "toid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNull() {
            addCriterion("departmentid is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNotNull() {
            addCriterion("departmentid is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidEqualTo(Integer value) {
            addCriterion("departmentid =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(Integer value) {
            addCriterion("departmentid <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(Integer value) {
            addCriterion("departmentid >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("departmentid >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(Integer value) {
            addCriterion("departmentid <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(Integer value) {
            addCriterion("departmentid <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<Integer> values) {
            addCriterion("departmentid in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<Integer> values) {
            addCriterion("departmentid not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(Integer value1, Integer value2) {
            addCriterion("departmentid between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(Integer value1, Integer value2) {
            addCriterion("departmentid not between", value1, value2, "departmentid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}