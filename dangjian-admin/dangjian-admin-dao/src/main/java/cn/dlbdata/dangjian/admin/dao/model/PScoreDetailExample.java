package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PScoreDetailExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public PScoreDetailExample() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(BigDecimal value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(BigDecimal value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(BigDecimal value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(BigDecimal value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<BigDecimal> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<BigDecimal> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andOnlyYnIsNull() {
            addCriterion("only_yn is null");
            return (Criteria) this;
        }

        public Criteria andOnlyYnIsNotNull() {
            addCriterion("only_yn is not null");
            return (Criteria) this;
        }

        public Criteria andOnlyYnEqualTo(String value) {
            addCriterion("only_yn =", value, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnNotEqualTo(String value) {
            addCriterion("only_yn <>", value, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnGreaterThan(String value) {
            addCriterion("only_yn >", value, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnGreaterThanOrEqualTo(String value) {
            addCriterion("only_yn >=", value, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnLessThan(String value) {
            addCriterion("only_yn <", value, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnLessThanOrEqualTo(String value) {
            addCriterion("only_yn <=", value, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnLike(String value) {
            addCriterion("only_yn like", value, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnNotLike(String value) {
            addCriterion("only_yn not like", value, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnIn(List<String> values) {
            addCriterion("only_yn in", values, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnNotIn(List<String> values) {
            addCriterion("only_yn not in", values, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnBetween(String value1, String value2) {
            addCriterion("only_yn between", value1, value2, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andOnlyYnNotBetween(String value1, String value2) {
            addCriterion("only_yn not between", value1, value2, "onlyYn");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdIsNull() {
            addCriterion("actor_role_id is null");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdIsNotNull() {
            addCriterion("actor_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdEqualTo(Integer value) {
            addCriterion("actor_role_id =", value, "actorRoleId");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdNotEqualTo(Integer value) {
            addCriterion("actor_role_id <>", value, "actorRoleId");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdGreaterThan(Integer value) {
            addCriterion("actor_role_id >", value, "actorRoleId");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("actor_role_id >=", value, "actorRoleId");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdLessThan(Integer value) {
            addCriterion("actor_role_id <", value, "actorRoleId");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("actor_role_id <=", value, "actorRoleId");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdIn(List<Integer> values) {
            addCriterion("actor_role_id in", values, "actorRoleId");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdNotIn(List<Integer> values) {
            addCriterion("actor_role_id not in", values, "actorRoleId");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("actor_role_id between", value1, value2, "actorRoleId");
            return (Criteria) this;
        }

        public Criteria andActorRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("actor_role_id not between", value1, value2, "actorRoleId");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdIsNull() {
            addCriterion("adder_role_id is null");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdIsNotNull() {
            addCriterion("adder_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdEqualTo(Integer value) {
            addCriterion("adder_role_id =", value, "adderRoleId");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdNotEqualTo(Integer value) {
            addCriterion("adder_role_id <>", value, "adderRoleId");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdGreaterThan(Integer value) {
            addCriterion("adder_role_id >", value, "adderRoleId");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adder_role_id >=", value, "adderRoleId");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdLessThan(Integer value) {
            addCriterion("adder_role_id <", value, "adderRoleId");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("adder_role_id <=", value, "adderRoleId");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdIn(List<Integer> values) {
            addCriterion("adder_role_id in", values, "adderRoleId");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdNotIn(List<Integer> values) {
            addCriterion("adder_role_id not in", values, "adderRoleId");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("adder_role_id between", value1, value2, "adderRoleId");
            return (Criteria) this;
        }

        public Criteria andAdderRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adder_role_id not between", value1, value2, "adderRoleId");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdIsNull() {
            addCriterion("approved_role_id is null");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdIsNotNull() {
            addCriterion("approved_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdEqualTo(Integer value) {
            addCriterion("approved_role_id =", value, "approvedRoleId");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdNotEqualTo(Integer value) {
            addCriterion("approved_role_id <>", value, "approvedRoleId");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdGreaterThan(Integer value) {
            addCriterion("approved_role_id >", value, "approvedRoleId");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("approved_role_id >=", value, "approvedRoleId");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdLessThan(Integer value) {
            addCriterion("approved_role_id <", value, "approvedRoleId");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("approved_role_id <=", value, "approvedRoleId");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdIn(List<Integer> values) {
            addCriterion("approved_role_id in", values, "approvedRoleId");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdNotIn(List<Integer> values) {
            addCriterion("approved_role_id not in", values, "approvedRoleId");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("approved_role_id between", value1, value2, "approvedRoleId");
            return (Criteria) this;
        }

        public Criteria andApprovedRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("approved_role_id not between", value1, value2, "approvedRoleId");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNull() {
            addCriterion("add_id is null");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNotNull() {
            addCriterion("add_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddIdEqualTo(Integer value) {
            addCriterion("add_id =", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotEqualTo(Integer value) {
            addCriterion("add_id <>", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThan(Integer value) {
            addCriterion("add_id >", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_id >=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThan(Integer value) {
            addCriterion("add_id <", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThanOrEqualTo(Integer value) {
            addCriterion("add_id <=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdIn(List<Integer> values) {
            addCriterion("add_id in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotIn(List<Integer> values) {
            addCriterion("add_id not in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdBetween(Integer value1, Integer value2) {
            addCriterion("add_id between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotBetween(Integer value1, Integer value2) {
            addCriterion("add_id not between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterion("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterion("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterion("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterion("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterion("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterion("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterion("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andValidYnIsNull() {
            addCriterion("valid_yn is null");
            return (Criteria) this;
        }

        public Criteria andValidYnIsNotNull() {
            addCriterion("valid_yn is not null");
            return (Criteria) this;
        }

        public Criteria andValidYnEqualTo(String value) {
            addCriterion("valid_yn =", value, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnNotEqualTo(String value) {
            addCriterion("valid_yn <>", value, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnGreaterThan(String value) {
            addCriterion("valid_yn >", value, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnGreaterThanOrEqualTo(String value) {
            addCriterion("valid_yn >=", value, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnLessThan(String value) {
            addCriterion("valid_yn <", value, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnLessThanOrEqualTo(String value) {
            addCriterion("valid_yn <=", value, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnLike(String value) {
            addCriterion("valid_yn like", value, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnNotLike(String value) {
            addCriterion("valid_yn not like", value, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnIn(List<String> values) {
            addCriterion("valid_yn in", values, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnNotIn(List<String> values) {
            addCriterion("valid_yn not in", values, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnBetween(String value1, String value2) {
            addCriterion("valid_yn between", value1, value2, "validYn");
            return (Criteria) this;
        }

        public Criteria andValidYnNotBetween(String value1, String value2) {
            addCriterion("valid_yn not between", value1, value2, "validYn");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdIsNull() {
            addCriterion("score_get_method_cd is null");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdIsNotNull() {
            addCriterion("score_get_method_cd is not null");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdEqualTo(String value) {
            addCriterion("score_get_method_cd =", value, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdNotEqualTo(String value) {
            addCriterion("score_get_method_cd <>", value, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdGreaterThan(String value) {
            addCriterion("score_get_method_cd >", value, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdGreaterThanOrEqualTo(String value) {
            addCriterion("score_get_method_cd >=", value, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdLessThan(String value) {
            addCriterion("score_get_method_cd <", value, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdLessThanOrEqualTo(String value) {
            addCriterion("score_get_method_cd <=", value, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdLike(String value) {
            addCriterion("score_get_method_cd like", value, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdNotLike(String value) {
            addCriterion("score_get_method_cd not like", value, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdIn(List<String> values) {
            addCriterion("score_get_method_cd in", values, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdNotIn(List<String> values) {
            addCriterion("score_get_method_cd not in", values, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdBetween(String value1, String value2) {
            addCriterion("score_get_method_cd between", value1, value2, "scoreGetMethodCd");
            return (Criteria) this;
        }

        public Criteria andScoreGetMethodCdNotBetween(String value1, String value2) {
            addCriterion("score_get_method_cd not between", value1, value2, "scoreGetMethodCd");
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