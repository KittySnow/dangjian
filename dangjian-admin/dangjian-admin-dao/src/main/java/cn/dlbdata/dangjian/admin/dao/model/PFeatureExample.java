package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PFeatureExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public PFeatureExample() {
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

        public Criteria andFeatureidIsNull() {
            addCriterion("featureid is null");
            return (Criteria) this;
        }

        public Criteria andFeatureidIsNotNull() {
            addCriterion("featureid is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureidEqualTo(Integer value) {
            addCriterion("featureid =", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidNotEqualTo(Integer value) {
            addCriterion("featureid <>", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidGreaterThan(Integer value) {
            addCriterion("featureid >", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidGreaterThanOrEqualTo(Integer value) {
            addCriterion("featureid >=", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidLessThan(Integer value) {
            addCriterion("featureid <", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidLessThanOrEqualTo(Integer value) {
            addCriterion("featureid <=", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidIn(List<Integer> values) {
            addCriterion("featureid in", values, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidNotIn(List<Integer> values) {
            addCriterion("featureid not in", values, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidBetween(Integer value1, Integer value2) {
            addCriterion("featureid between", value1, value2, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidNotBetween(Integer value1, Integer value2) {
            addCriterion("featureid not between", value1, value2, "featureid");
            return (Criteria) this;
        }

        public Criteria andEngnameIsNull() {
            addCriterion("engname is null");
            return (Criteria) this;
        }

        public Criteria andEngnameIsNotNull() {
            addCriterion("engname is not null");
            return (Criteria) this;
        }

        public Criteria andEngnameEqualTo(String value) {
            addCriterion("engname =", value, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameNotEqualTo(String value) {
            addCriterion("engname <>", value, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameGreaterThan(String value) {
            addCriterion("engname >", value, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameGreaterThanOrEqualTo(String value) {
            addCriterion("engname >=", value, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameLessThan(String value) {
            addCriterion("engname <", value, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameLessThanOrEqualTo(String value) {
            addCriterion("engname <=", value, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameLike(String value) {
            addCriterion("engname like", value, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameNotLike(String value) {
            addCriterion("engname not like", value, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameIn(List<String> values) {
            addCriterion("engname in", values, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameNotIn(List<String> values) {
            addCriterion("engname not in", values, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameBetween(String value1, String value2) {
            addCriterion("engname between", value1, value2, "engname");
            return (Criteria) this;
        }

        public Criteria andEngnameNotBetween(String value1, String value2) {
            addCriterion("engname not between", value1, value2, "engname");
            return (Criteria) this;
        }

        public Criteria andChnnameIsNull() {
            addCriterion("chnname is null");
            return (Criteria) this;
        }

        public Criteria andChnnameIsNotNull() {
            addCriterion("chnname is not null");
            return (Criteria) this;
        }

        public Criteria andChnnameEqualTo(String value) {
            addCriterion("chnname =", value, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameNotEqualTo(String value) {
            addCriterion("chnname <>", value, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameGreaterThan(String value) {
            addCriterion("chnname >", value, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameGreaterThanOrEqualTo(String value) {
            addCriterion("chnname >=", value, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameLessThan(String value) {
            addCriterion("chnname <", value, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameLessThanOrEqualTo(String value) {
            addCriterion("chnname <=", value, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameLike(String value) {
            addCriterion("chnname like", value, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameNotLike(String value) {
            addCriterion("chnname not like", value, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameIn(List<String> values) {
            addCriterion("chnname in", values, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameNotIn(List<String> values) {
            addCriterion("chnname not in", values, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameBetween(String value1, String value2) {
            addCriterion("chnname between", value1, value2, "chnname");
            return (Criteria) this;
        }

        public Criteria andChnnameNotBetween(String value1, String value2) {
            addCriterion("chnname not between", value1, value2, "chnname");
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