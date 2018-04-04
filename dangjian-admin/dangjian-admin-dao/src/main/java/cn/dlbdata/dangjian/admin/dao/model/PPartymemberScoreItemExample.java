package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PPartymemberScoreItemExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public PPartymemberScoreItemExample() {
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

        public Criteria andItemidIsNull() {
            addCriterion("itemid is null");
            return (Criteria) this;
        }

        public Criteria andItemidIsNotNull() {
            addCriterion("itemid is not null");
            return (Criteria) this;
        }

        public Criteria andItemidEqualTo(Integer value) {
            addCriterion("itemid =", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotEqualTo(Integer value) {
            addCriterion("itemid <>", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThan(Integer value) {
            addCriterion("itemid >", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("itemid >=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThan(Integer value) {
            addCriterion("itemid <", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThanOrEqualTo(Integer value) {
            addCriterion("itemid <=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidIn(List<Integer> values) {
            addCriterion("itemid in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotIn(List<Integer> values) {
            addCriterion("itemid not in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidBetween(Integer value1, Integer value2) {
            addCriterion("itemid between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotBetween(Integer value1, Integer value2) {
            addCriterion("itemid not between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidIsNull() {
            addCriterion("partymemberid is null");
            return (Criteria) this;
        }

        public Criteria andPartymemberidIsNotNull() {
            addCriterion("partymemberid is not null");
            return (Criteria) this;
        }

        public Criteria andPartymemberidEqualTo(Integer value) {
            addCriterion("partymemberid =", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotEqualTo(Integer value) {
            addCriterion("partymemberid <>", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidGreaterThan(Integer value) {
            addCriterion("partymemberid >", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("partymemberid >=", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidLessThan(Integer value) {
            addCriterion("partymemberid <", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidLessThanOrEqualTo(Integer value) {
            addCriterion("partymemberid <=", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidIn(List<Integer> values) {
            addCriterion("partymemberid in", values, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotIn(List<Integer> values) {
            addCriterion("partymemberid not in", values, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidBetween(Integer value1, Integer value2) {
            addCriterion("partymemberid between", value1, value2, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("partymemberid not between", value1, value2, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andScorepartyidIsNull() {
            addCriterion("scorepartyid is null");
            return (Criteria) this;
        }

        public Criteria andScorepartyidIsNotNull() {
            addCriterion("scorepartyid is not null");
            return (Criteria) this;
        }

        public Criteria andScorepartyidEqualTo(Integer value) {
            addCriterion("scorepartyid =", value, "scorepartyid");
            return (Criteria) this;
        }

        public Criteria andScorepartyidNotEqualTo(Integer value) {
            addCriterion("scorepartyid <>", value, "scorepartyid");
            return (Criteria) this;
        }

        public Criteria andScorepartyidGreaterThan(Integer value) {
            addCriterion("scorepartyid >", value, "scorepartyid");
            return (Criteria) this;
        }

        public Criteria andScorepartyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("scorepartyid >=", value, "scorepartyid");
            return (Criteria) this;
        }

        public Criteria andScorepartyidLessThan(Integer value) {
            addCriterion("scorepartyid <", value, "scorepartyid");
            return (Criteria) this;
        }

        public Criteria andScorepartyidLessThanOrEqualTo(Integer value) {
            addCriterion("scorepartyid <=", value, "scorepartyid");
            return (Criteria) this;
        }

        public Criteria andScorepartyidIn(List<Integer> values) {
            addCriterion("scorepartyid in", values, "scorepartyid");
            return (Criteria) this;
        }

        public Criteria andScorepartyidNotIn(List<Integer> values) {
            addCriterion("scorepartyid not in", values, "scorepartyid");
            return (Criteria) this;
        }

        public Criteria andScorepartyidBetween(Integer value1, Integer value2) {
            addCriterion("scorepartyid between", value1, value2, "scorepartyid");
            return (Criteria) this;
        }

        public Criteria andScorepartyidNotBetween(Integer value1, Integer value2) {
            addCriterion("scorepartyid not between", value1, value2, "scorepartyid");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andPictureidIsNull() {
            addCriterion("pictureid is null");
            return (Criteria) this;
        }

        public Criteria andPictureidIsNotNull() {
            addCriterion("pictureid is not null");
            return (Criteria) this;
        }

        public Criteria andPictureidEqualTo(Integer value) {
            addCriterion("pictureid =", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidNotEqualTo(Integer value) {
            addCriterion("pictureid <>", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidGreaterThan(Integer value) {
            addCriterion("pictureid >", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pictureid >=", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidLessThan(Integer value) {
            addCriterion("pictureid <", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidLessThanOrEqualTo(Integer value) {
            addCriterion("pictureid <=", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidIn(List<Integer> values) {
            addCriterion("pictureid in", values, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidNotIn(List<Integer> values) {
            addCriterion("pictureid not in", values, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidBetween(Integer value1, Integer value2) {
            addCriterion("pictureid between", value1, value2, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidNotBetween(Integer value1, Integer value2) {
            addCriterion("pictureid not between", value1, value2, "pictureid");
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