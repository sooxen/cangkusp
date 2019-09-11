package com.lin.cangkusp.pojo;

import java.util.ArrayList;
import java.util.List;

public class WarehouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WarehouseExample() {
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

        public Criteria andWnoIsNull() {
            addCriterion("wno is null");
            return (Criteria) this;
        }

        public Criteria andWnoIsNotNull() {
            addCriterion("wno is not null");
            return (Criteria) this;
        }

        public Criteria andWnoEqualTo(String value) {
            addCriterion("wno =", value, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoNotEqualTo(String value) {
            addCriterion("wno <>", value, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoGreaterThan(String value) {
            addCriterion("wno >", value, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoGreaterThanOrEqualTo(String value) {
            addCriterion("wno >=", value, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoLessThan(String value) {
            addCriterion("wno <", value, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoLessThanOrEqualTo(String value) {
            addCriterion("wno <=", value, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoLike(String value) {
            addCriterion("wno like", value, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoNotLike(String value) {
            addCriterion("wno not like", value, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoIn(List<String> values) {
            addCriterion("wno in", values, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoNotIn(List<String> values) {
            addCriterion("wno not in", values, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoBetween(String value1, String value2) {
            addCriterion("wno between", value1, value2, "wno");
            return (Criteria) this;
        }

        public Criteria andWnoNotBetween(String value1, String value2) {
            addCriterion("wno not between", value1, value2, "wno");
            return (Criteria) this;
        }

        public Criteria andWnameIsNull() {
            addCriterion("wname is null");
            return (Criteria) this;
        }

        public Criteria andWnameIsNotNull() {
            addCriterion("wname is not null");
            return (Criteria) this;
        }

        public Criteria andWnameEqualTo(String value) {
            addCriterion("wname =", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotEqualTo(String value) {
            addCriterion("wname <>", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameGreaterThan(String value) {
            addCriterion("wname >", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameGreaterThanOrEqualTo(String value) {
            addCriterion("wname >=", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameLessThan(String value) {
            addCriterion("wname <", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameLessThanOrEqualTo(String value) {
            addCriterion("wname <=", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameLike(String value) {
            addCriterion("wname like", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotLike(String value) {
            addCriterion("wname not like", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameIn(List<String> values) {
            addCriterion("wname in", values, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotIn(List<String> values) {
            addCriterion("wname not in", values, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameBetween(String value1, String value2) {
            addCriterion("wname between", value1, value2, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotBetween(String value1, String value2) {
            addCriterion("wname not between", value1, value2, "wname");
            return (Criteria) this;
        }

        public Criteria andWaddressIsNull() {
            addCriterion("waddress is null");
            return (Criteria) this;
        }

        public Criteria andWaddressIsNotNull() {
            addCriterion("waddress is not null");
            return (Criteria) this;
        }

        public Criteria andWaddressEqualTo(String value) {
            addCriterion("waddress =", value, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressNotEqualTo(String value) {
            addCriterion("waddress <>", value, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressGreaterThan(String value) {
            addCriterion("waddress >", value, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressGreaterThanOrEqualTo(String value) {
            addCriterion("waddress >=", value, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressLessThan(String value) {
            addCriterion("waddress <", value, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressLessThanOrEqualTo(String value) {
            addCriterion("waddress <=", value, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressLike(String value) {
            addCriterion("waddress like", value, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressNotLike(String value) {
            addCriterion("waddress not like", value, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressIn(List<String> values) {
            addCriterion("waddress in", values, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressNotIn(List<String> values) {
            addCriterion("waddress not in", values, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressBetween(String value1, String value2) {
            addCriterion("waddress between", value1, value2, "waddress");
            return (Criteria) this;
        }

        public Criteria andWaddressNotBetween(String value1, String value2) {
            addCriterion("waddress not between", value1, value2, "waddress");
            return (Criteria) this;
        }

        public Criteria andSnoIsNull() {
            addCriterion("sno is null");
            return (Criteria) this;
        }

        public Criteria andSnoIsNotNull() {
            addCriterion("sno is not null");
            return (Criteria) this;
        }

        public Criteria andSnoEqualTo(String value) {
            addCriterion("sno =", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotEqualTo(String value) {
            addCriterion("sno <>", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThan(String value) {
            addCriterion("sno >", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThanOrEqualTo(String value) {
            addCriterion("sno >=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThan(String value) {
            addCriterion("sno <", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThanOrEqualTo(String value) {
            addCriterion("sno <=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLike(String value) {
            addCriterion("sno like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotLike(String value) {
            addCriterion("sno not like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoIn(List<String> values) {
            addCriterion("sno in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotIn(List<String> values) {
            addCriterion("sno not in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoBetween(String value1, String value2) {
            addCriterion("sno between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotBetween(String value1, String value2) {
            addCriterion("sno not between", value1, value2, "sno");
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