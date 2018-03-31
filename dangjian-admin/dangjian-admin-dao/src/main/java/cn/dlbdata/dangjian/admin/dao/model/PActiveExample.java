package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PActiveExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public PActiveExample() {
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

        public Criteria andActiveNameIsNull() {
            addCriterion("active_name is null");
            return (Criteria) this;
        }

        public Criteria andActiveNameIsNotNull() {
            addCriterion("active_name is not null");
            return (Criteria) this;
        }

        public Criteria andActiveNameEqualTo(String value) {
            addCriterion("active_name =", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotEqualTo(String value) {
            addCriterion("active_name <>", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameGreaterThan(String value) {
            addCriterion("active_name >", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("active_name >=", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameLessThan(String value) {
            addCriterion("active_name <", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameLessThanOrEqualTo(String value) {
            addCriterion("active_name <=", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameLike(String value) {
            addCriterion("active_name like", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotLike(String value) {
            addCriterion("active_name not like", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameIn(List<String> values) {
            addCriterion("active_name in", values, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotIn(List<String> values) {
            addCriterion("active_name not in", values, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameBetween(String value1, String value2) {
            addCriterion("active_name between", value1, value2, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotBetween(String value1, String value2) {
            addCriterion("active_name not between", value1, value2, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdIsNull() {
            addCriterion("active_project_id is null");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdIsNotNull() {
            addCriterion("active_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdEqualTo(Integer value) {
            addCriterion("active_project_id =", value, "activeProjectId");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdNotEqualTo(Integer value) {
            addCriterion("active_project_id <>", value, "activeProjectId");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdGreaterThan(Integer value) {
            addCriterion("active_project_id >", value, "activeProjectId");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_project_id >=", value, "activeProjectId");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdLessThan(Integer value) {
            addCriterion("active_project_id <", value, "activeProjectId");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("active_project_id <=", value, "activeProjectId");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdIn(List<Integer> values) {
            addCriterion("active_project_id in", values, "activeProjectId");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdNotIn(List<Integer> values) {
            addCriterion("active_project_id not in", values, "activeProjectId");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("active_project_id between", value1, value2, "activeProjectId");
            return (Criteria) this;
        }

        public Criteria andActiveProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("active_project_id not between", value1, value2, "activeProjectId");
            return (Criteria) this;
        }

        public Criteria andActiveTypeIsNull() {
            addCriterion("active_type is null");
            return (Criteria) this;
        }

        public Criteria andActiveTypeIsNotNull() {
            addCriterion("active_type is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTypeEqualTo(Integer value) {
            addCriterion("active_type =", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeNotEqualTo(Integer value) {
            addCriterion("active_type <>", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeGreaterThan(Integer value) {
            addCriterion("active_type >", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_type >=", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeLessThan(Integer value) {
            addCriterion("active_type <", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeLessThanOrEqualTo(Integer value) {
            addCriterion("active_type <=", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeIn(List<Integer> values) {
            addCriterion("active_type in", values, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeNotIn(List<Integer> values) {
            addCriterion("active_type not in", values, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeBetween(Integer value1, Integer value2) {
            addCriterion("active_type between", value1, value2, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("active_type not between", value1, value2, "activeType");
            return (Criteria) this;
        }

        public Criteria andActivePaceIsNull() {
            addCriterion("active_pace is null");
            return (Criteria) this;
        }

        public Criteria andActivePaceIsNotNull() {
            addCriterion("active_pace is not null");
            return (Criteria) this;
        }

        public Criteria andActivePaceEqualTo(String value) {
            addCriterion("active_pace =", value, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceNotEqualTo(String value) {
            addCriterion("active_pace <>", value, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceGreaterThan(String value) {
            addCriterion("active_pace >", value, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceGreaterThanOrEqualTo(String value) {
            addCriterion("active_pace >=", value, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceLessThan(String value) {
            addCriterion("active_pace <", value, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceLessThanOrEqualTo(String value) {
            addCriterion("active_pace <=", value, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceLike(String value) {
            addCriterion("active_pace like", value, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceNotLike(String value) {
            addCriterion("active_pace not like", value, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceIn(List<String> values) {
            addCriterion("active_pace in", values, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceNotIn(List<String> values) {
            addCriterion("active_pace not in", values, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceBetween(String value1, String value2) {
            addCriterion("active_pace between", value1, value2, "activePace");
            return (Criteria) this;
        }

        public Criteria andActivePaceNotBetween(String value1, String value2) {
            addCriterion("active_pace not between", value1, value2, "activePace");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleIsNull() {
            addCriterion("active_create_people is null");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleIsNotNull() {
            addCriterion("active_create_people is not null");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleEqualTo(String value) {
            addCriterion("active_create_people =", value, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleNotEqualTo(String value) {
            addCriterion("active_create_people <>", value, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleGreaterThan(String value) {
            addCriterion("active_create_people >", value, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("active_create_people >=", value, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleLessThan(String value) {
            addCriterion("active_create_people <", value, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleLessThanOrEqualTo(String value) {
            addCriterion("active_create_people <=", value, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleLike(String value) {
            addCriterion("active_create_people like", value, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleNotLike(String value) {
            addCriterion("active_create_people not like", value, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleIn(List<String> values) {
            addCriterion("active_create_people in", values, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleNotIn(List<String> values) {
            addCriterion("active_create_people not in", values, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleBetween(String value1, String value2) {
            addCriterion("active_create_people between", value1, value2, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActiveCreatePeopleNotBetween(String value1, String value2) {
            addCriterion("active_create_people not between", value1, value2, "activeCreatePeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleIsNull() {
            addCriterion("active_principal_people is null");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleIsNotNull() {
            addCriterion("active_principal_people is not null");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleEqualTo(String value) {
            addCriterion("active_principal_people =", value, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleNotEqualTo(String value) {
            addCriterion("active_principal_people <>", value, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleGreaterThan(String value) {
            addCriterion("active_principal_people >", value, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("active_principal_people >=", value, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleLessThan(String value) {
            addCriterion("active_principal_people <", value, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleLessThanOrEqualTo(String value) {
            addCriterion("active_principal_people <=", value, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleLike(String value) {
            addCriterion("active_principal_people like", value, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleNotLike(String value) {
            addCriterion("active_principal_people not like", value, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleIn(List<String> values) {
            addCriterion("active_principal_people in", values, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleNotIn(List<String> values) {
            addCriterion("active_principal_people not in", values, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleBetween(String value1, String value2) {
            addCriterion("active_principal_people between", value1, value2, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActivePrincipalPeopleNotBetween(String value1, String value2) {
            addCriterion("active_principal_people not between", value1, value2, "activePrincipalPeople");
            return (Criteria) this;
        }

        public Criteria andActiveStatusIsNull() {
            addCriterion("active_status is null");
            return (Criteria) this;
        }

        public Criteria andActiveStatusIsNotNull() {
            addCriterion("active_status is not null");
            return (Criteria) this;
        }

        public Criteria andActiveStatusEqualTo(Integer value) {
            addCriterion("active_status =", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusNotEqualTo(Integer value) {
            addCriterion("active_status <>", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusGreaterThan(Integer value) {
            addCriterion("active_status >", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_status >=", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusLessThan(Integer value) {
            addCriterion("active_status <", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusLessThanOrEqualTo(Integer value) {
            addCriterion("active_status <=", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusIn(List<Integer> values) {
            addCriterion("active_status in", values, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusNotIn(List<Integer> values) {
            addCriterion("active_status not in", values, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusBetween(Integer value1, Integer value2) {
            addCriterion("active_status between", value1, value2, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("active_status not between", value1, value2, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andActiveContextIsNull() {
            addCriterion("active_context is null");
            return (Criteria) this;
        }

        public Criteria andActiveContextIsNotNull() {
            addCriterion("active_context is not null");
            return (Criteria) this;
        }

        public Criteria andActiveContextEqualTo(String value) {
            addCriterion("active_context =", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextNotEqualTo(String value) {
            addCriterion("active_context <>", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextGreaterThan(String value) {
            addCriterion("active_context >", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextGreaterThanOrEqualTo(String value) {
            addCriterion("active_context >=", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextLessThan(String value) {
            addCriterion("active_context <", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextLessThanOrEqualTo(String value) {
            addCriterion("active_context <=", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextLike(String value) {
            addCriterion("active_context like", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextNotLike(String value) {
            addCriterion("active_context not like", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextIn(List<String> values) {
            addCriterion("active_context in", values, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextNotIn(List<String> values) {
            addCriterion("active_context not in", values, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextBetween(String value1, String value2) {
            addCriterion("active_context between", value1, value2, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextNotBetween(String value1, String value2) {
            addCriterion("active_context not between", value1, value2, "activeContext");
            return (Criteria) this;
        }

        public Criteria andZbMessageIsNull() {
            addCriterion("zb_message is null");
            return (Criteria) this;
        }

        public Criteria andZbMessageIsNotNull() {
            addCriterion("zb_message is not null");
            return (Criteria) this;
        }

        public Criteria andZbMessageEqualTo(String value) {
            addCriterion("zb_message =", value, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageNotEqualTo(String value) {
            addCriterion("zb_message <>", value, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageGreaterThan(String value) {
            addCriterion("zb_message >", value, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageGreaterThanOrEqualTo(String value) {
            addCriterion("zb_message >=", value, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageLessThan(String value) {
            addCriterion("zb_message <", value, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageLessThanOrEqualTo(String value) {
            addCriterion("zb_message <=", value, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageLike(String value) {
            addCriterion("zb_message like", value, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageNotLike(String value) {
            addCriterion("zb_message not like", value, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageIn(List<String> values) {
            addCriterion("zb_message in", values, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageNotIn(List<String> values) {
            addCriterion("zb_message not in", values, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageBetween(String value1, String value2) {
            addCriterion("zb_message between", value1, value2, "zbMessage");
            return (Criteria) this;
        }

        public Criteria andZbMessageNotBetween(String value1, String value2) {
            addCriterion("zb_message not between", value1, value2, "zbMessage");
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