package com.lin.cangkusp.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProviderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProviderExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andPnoIsNull() {
            addCriterion("pno is null");
            return (Criteria) this;
        }

        public Criteria andPnoIsNotNull() {
            addCriterion("pno is not null");
            return (Criteria) this;
        }

        public Criteria andPnoEqualTo(String value) {
            addCriterion("pno =", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoNotEqualTo(String value) {
            addCriterion("pno <>", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoGreaterThan(String value) {
            addCriterion("pno >", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoGreaterThanOrEqualTo(String value) {
            addCriterion("pno >=", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoLessThan(String value) {
            addCriterion("pno <", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoLessThanOrEqualTo(String value) {
            addCriterion("pno <=", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoLike(String value) {
            addCriterion("pno like", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoNotLike(String value) {
            addCriterion("pno not like", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoIn(List<String> values) {
            addCriterion("pno in", values, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoNotIn(List<String> values) {
            addCriterion("pno not in", values, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoBetween(String value1, String value2) {
            addCriterion("pno between", value1, value2, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoNotBetween(String value1, String value2) {
            addCriterion("pno not between", value1, value2, "pno");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPaddressIsNull() {
            addCriterion("paddress is null");
            return (Criteria) this;
        }

        public Criteria andPaddressIsNotNull() {
            addCriterion("paddress is not null");
            return (Criteria) this;
        }

        public Criteria andPaddressEqualTo(String value) {
            addCriterion("paddress =", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressNotEqualTo(String value) {
            addCriterion("paddress <>", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressGreaterThan(String value) {
            addCriterion("paddress >", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressGreaterThanOrEqualTo(String value) {
            addCriterion("paddress >=", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressLessThan(String value) {
            addCriterion("paddress <", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressLessThanOrEqualTo(String value) {
            addCriterion("paddress <=", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressLike(String value) {
            addCriterion("paddress like", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressNotLike(String value) {
            addCriterion("paddress not like", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressIn(List<String> values) {
            addCriterion("paddress in", values, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressNotIn(List<String> values) {
            addCriterion("paddress not in", values, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressBetween(String value1, String value2) {
            addCriterion("paddress between", value1, value2, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressNotBetween(String value1, String value2) {
            addCriterion("paddress not between", value1, value2, "paddress");
            return (Criteria) this;
        }

        public Criteria andPtelIsNull() {
            addCriterion("ptel is null");
            return (Criteria) this;
        }

        public Criteria andPtelIsNotNull() {
            addCriterion("ptel is not null");
            return (Criteria) this;
        }

        public Criteria andPtelEqualTo(String value) {
            addCriterion("ptel =", value, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelNotEqualTo(String value) {
            addCriterion("ptel <>", value, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelGreaterThan(String value) {
            addCriterion("ptel >", value, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelGreaterThanOrEqualTo(String value) {
            addCriterion("ptel >=", value, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelLessThan(String value) {
            addCriterion("ptel <", value, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelLessThanOrEqualTo(String value) {
            addCriterion("ptel <=", value, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelLike(String value) {
            addCriterion("ptel like", value, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelNotLike(String value) {
            addCriterion("ptel not like", value, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelIn(List<String> values) {
            addCriterion("ptel in", values, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelNotIn(List<String> values) {
            addCriterion("ptel not in", values, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelBetween(String value1, String value2) {
            addCriterion("ptel between", value1, value2, "ptel");
            return (Criteria) this;
        }

        public Criteria andPtelNotBetween(String value1, String value2) {
            addCriterion("ptel not between", value1, value2, "ptel");
            return (Criteria) this;
        }

        public Criteria andPcommentIsNull() {
            addCriterion("pcomment is null");
            return (Criteria) this;
        }

        public Criteria andPcommentIsNotNull() {
            addCriterion("pcomment is not null");
            return (Criteria) this;
        }

        public Criteria andPcommentEqualTo(String value) {
            addCriterion("pcomment =", value, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentNotEqualTo(String value) {
            addCriterion("pcomment <>", value, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentGreaterThan(String value) {
            addCriterion("pcomment >", value, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentGreaterThanOrEqualTo(String value) {
            addCriterion("pcomment >=", value, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentLessThan(String value) {
            addCriterion("pcomment <", value, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentLessThanOrEqualTo(String value) {
            addCriterion("pcomment <=", value, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentLike(String value) {
            addCriterion("pcomment like", value, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentNotLike(String value) {
            addCriterion("pcomment not like", value, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentIn(List<String> values) {
            addCriterion("pcomment in", values, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentNotIn(List<String> values) {
            addCriterion("pcomment not in", values, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentBetween(String value1, String value2) {
            addCriterion("pcomment between", value1, value2, "pcomment");
            return (Criteria) this;
        }

        public Criteria andPcommentNotBetween(String value1, String value2) {
            addCriterion("pcomment not between", value1, value2, "pcomment");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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