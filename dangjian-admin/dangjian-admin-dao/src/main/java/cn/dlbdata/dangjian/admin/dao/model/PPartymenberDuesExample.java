package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PPartymenberDuesExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public PPartymenberDuesExample() {
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

        public Criteria andDuesIdIsNull() {
            addCriterion("dues_id is null");
            return (Criteria) this;
        }

        public Criteria andDuesIdIsNotNull() {
            addCriterion("dues_id is not null");
            return (Criteria) this;
        }

        public Criteria andDuesIdEqualTo(Integer value) {
            addCriterion("dues_id =", value, "duesId");
            return (Criteria) this;
        }

        public Criteria andDuesIdNotEqualTo(Integer value) {
            addCriterion("dues_id <>", value, "duesId");
            return (Criteria) this;
        }

        public Criteria andDuesIdGreaterThan(Integer value) {
            addCriterion("dues_id >", value, "duesId");
            return (Criteria) this;
        }

        public Criteria andDuesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dues_id >=", value, "duesId");
            return (Criteria) this;
        }

        public Criteria andDuesIdLessThan(Integer value) {
            addCriterion("dues_id <", value, "duesId");
            return (Criteria) this;
        }

        public Criteria andDuesIdLessThanOrEqualTo(Integer value) {
            addCriterion("dues_id <=", value, "duesId");
            return (Criteria) this;
        }

        public Criteria andDuesIdIn(List<Integer> values) {
            addCriterion("dues_id in", values, "duesId");
            return (Criteria) this;
        }

        public Criteria andDuesIdNotIn(List<Integer> values) {
            addCriterion("dues_id not in", values, "duesId");
            return (Criteria) this;
        }

        public Criteria andDuesIdBetween(Integer value1, Integer value2) {
            addCriterion("dues_id between", value1, value2, "duesId");
            return (Criteria) this;
        }

        public Criteria andDuesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dues_id not between", value1, value2, "duesId");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdIsNull() {
            addCriterion("party_member_id is null");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdIsNotNull() {
            addCriterion("party_member_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdEqualTo(Integer value) {
            addCriterion("party_member_id =", value, "partyMemberId");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdNotEqualTo(Integer value) {
            addCriterion("party_member_id <>", value, "partyMemberId");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdGreaterThan(Integer value) {
            addCriterion("party_member_id >", value, "partyMemberId");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("party_member_id >=", value, "partyMemberId");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdLessThan(Integer value) {
            addCriterion("party_member_id <", value, "partyMemberId");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("party_member_id <=", value, "partyMemberId");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdIn(List<Integer> values) {
            addCriterion("party_member_id in", values, "partyMemberId");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdNotIn(List<Integer> values) {
            addCriterion("party_member_id not in", values, "partyMemberId");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("party_member_id between", value1, value2, "partyMemberId");
            return (Criteria) this;
        }

        public Criteria andPartyMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("party_member_id not between", value1, value2, "partyMemberId");
            return (Criteria) this;
        }

        public Criteria andDuesIsNull() {
            addCriterion("dues is null");
            return (Criteria) this;
        }

        public Criteria andDuesIsNotNull() {
            addCriterion("dues is not null");
            return (Criteria) this;
        }

        public Criteria andDuesEqualTo(String value) {
            addCriterion("dues =", value, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesNotEqualTo(String value) {
            addCriterion("dues <>", value, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesGreaterThan(String value) {
            addCriterion("dues >", value, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesGreaterThanOrEqualTo(String value) {
            addCriterion("dues >=", value, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesLessThan(String value) {
            addCriterion("dues <", value, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesLessThanOrEqualTo(String value) {
            addCriterion("dues <=", value, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesLike(String value) {
            addCriterion("dues like", value, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesNotLike(String value) {
            addCriterion("dues not like", value, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesIn(List<String> values) {
            addCriterion("dues in", values, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesNotIn(List<String> values) {
            addCriterion("dues not in", values, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesBetween(String value1, String value2) {
            addCriterion("dues between", value1, value2, "dues");
            return (Criteria) this;
        }

        public Criteria andDuesNotBetween(String value1, String value2) {
            addCriterion("dues not between", value1, value2, "dues");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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