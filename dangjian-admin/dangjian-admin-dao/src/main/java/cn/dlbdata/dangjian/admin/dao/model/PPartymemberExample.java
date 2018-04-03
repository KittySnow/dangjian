package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PPartymemberExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public PPartymemberExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andOutZbIsNull() {
            addCriterion("out_zb is null");
            return (Criteria) this;
        }

        public Criteria andOutZbIsNotNull() {
            addCriterion("out_zb is not null");
            return (Criteria) this;
        }

        public Criteria andOutZbEqualTo(String value) {
            addCriterion("out_zb =", value, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbNotEqualTo(String value) {
            addCriterion("out_zb <>", value, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbGreaterThan(String value) {
            addCriterion("out_zb >", value, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbGreaterThanOrEqualTo(String value) {
            addCriterion("out_zb >=", value, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbLessThan(String value) {
            addCriterion("out_zb <", value, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbLessThanOrEqualTo(String value) {
            addCriterion("out_zb <=", value, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbLike(String value) {
            addCriterion("out_zb like", value, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbNotLike(String value) {
            addCriterion("out_zb not like", value, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbIn(List<String> values) {
            addCriterion("out_zb in", values, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbNotIn(List<String> values) {
            addCriterion("out_zb not in", values, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbBetween(String value1, String value2) {
            addCriterion("out_zb between", value1, value2, "outZb");
            return (Criteria) this;
        }

        public Criteria andOutZbNotBetween(String value1, String value2) {
            addCriterion("out_zb not between", value1, value2, "outZb");
            return (Criteria) this;
        }

        public Criteria andMomentScoreIsNull() {
            addCriterion("moment_score is null");
            return (Criteria) this;
        }

        public Criteria andMomentScoreIsNotNull() {
            addCriterion("moment_score is not null");
            return (Criteria) this;
        }

        public Criteria andMomentScoreEqualTo(String value) {
            addCriterion("moment_score =", value, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreNotEqualTo(String value) {
            addCriterion("moment_score <>", value, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreGreaterThan(String value) {
            addCriterion("moment_score >", value, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreGreaterThanOrEqualTo(String value) {
            addCriterion("moment_score >=", value, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreLessThan(String value) {
            addCriterion("moment_score <", value, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreLessThanOrEqualTo(String value) {
            addCriterion("moment_score <=", value, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreLike(String value) {
            addCriterion("moment_score like", value, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreNotLike(String value) {
            addCriterion("moment_score not like", value, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreIn(List<String> values) {
            addCriterion("moment_score in", values, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreNotIn(List<String> values) {
            addCriterion("moment_score not in", values, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreBetween(String value1, String value2) {
            addCriterion("moment_score between", value1, value2, "momentScore");
            return (Criteria) this;
        }

        public Criteria andMomentScoreNotBetween(String value1, String value2) {
            addCriterion("moment_score not between", value1, value2, "momentScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreIsNull() {
            addCriterion("near_score is null");
            return (Criteria) this;
        }

        public Criteria andNearScoreIsNotNull() {
            addCriterion("near_score is not null");
            return (Criteria) this;
        }

        public Criteria andNearScoreEqualTo(String value) {
            addCriterion("near_score =", value, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreNotEqualTo(String value) {
            addCriterion("near_score <>", value, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreGreaterThan(String value) {
            addCriterion("near_score >", value, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreGreaterThanOrEqualTo(String value) {
            addCriterion("near_score >=", value, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreLessThan(String value) {
            addCriterion("near_score <", value, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreLessThanOrEqualTo(String value) {
            addCriterion("near_score <=", value, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreLike(String value) {
            addCriterion("near_score like", value, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreNotLike(String value) {
            addCriterion("near_score not like", value, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreIn(List<String> values) {
            addCriterion("near_score in", values, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreNotIn(List<String> values) {
            addCriterion("near_score not in", values, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreBetween(String value1, String value2) {
            addCriterion("near_score between", value1, value2, "nearScore");
            return (Criteria) this;
        }

        public Criteria andNearScoreNotBetween(String value1, String value2) {
            addCriterion("near_score not between", value1, value2, "nearScore");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNull() {
            addCriterion("active_time is null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNotNull() {
            addCriterion("active_time is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeEqualTo(Integer value) {
            addCriterion("active_time =", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotEqualTo(Integer value) {
            addCriterion("active_time <>", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThan(Integer value) {
            addCriterion("active_time >", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_time >=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThan(Integer value) {
            addCriterion("active_time <", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThanOrEqualTo(Integer value) {
            addCriterion("active_time <=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIn(List<Integer> values) {
            addCriterion("active_time in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotIn(List<Integer> values) {
            addCriterion("active_time not in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeBetween(Integer value1, Integer value2) {
            addCriterion("active_time between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("active_time not between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeIsNull() {
            addCriterion("zz_studytime is null");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeIsNotNull() {
            addCriterion("zz_studytime is not null");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeEqualTo(Date value) {
            addCriterionForJDBCDate("zz_studytime =", value, "zzStudytime");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("zz_studytime <>", value, "zzStudytime");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("zz_studytime >", value, "zzStudytime");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("zz_studytime >=", value, "zzStudytime");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeLessThan(Date value) {
            addCriterionForJDBCDate("zz_studytime <", value, "zzStudytime");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("zz_studytime <=", value, "zzStudytime");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeIn(List<Date> values) {
            addCriterionForJDBCDate("zz_studytime in", values, "zzStudytime");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("zz_studytime not in", values, "zzStudytime");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("zz_studytime between", value1, value2, "zzStudytime");
            return (Criteria) this;
        }

        public Criteria andZzStudytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("zz_studytime not between", value1, value2, "zzStudytime");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
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