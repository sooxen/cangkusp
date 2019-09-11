package com.lin.cangkusp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreExample() {
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

        public Criteria andStnoIsNull() {
            addCriterion("stno is null");
            return (Criteria) this;
        }

        public Criteria andStnoIsNotNull() {
            addCriterion("stno is not null");
            return (Criteria) this;
        }

        public Criteria andStnoEqualTo(String value) {
            addCriterion("stno =", value, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoNotEqualTo(String value) {
            addCriterion("stno <>", value, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoGreaterThan(String value) {
            addCriterion("stno >", value, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoGreaterThanOrEqualTo(String value) {
            addCriterion("stno >=", value, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoLessThan(String value) {
            addCriterion("stno <", value, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoLessThanOrEqualTo(String value) {
            addCriterion("stno <=", value, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoLike(String value) {
            addCriterion("stno like", value, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoNotLike(String value) {
            addCriterion("stno not like", value, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoIn(List<String> values) {
            addCriterion("stno in", values, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoNotIn(List<String> values) {
            addCriterion("stno not in", values, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoBetween(String value1, String value2) {
            addCriterion("stno between", value1, value2, "stno");
            return (Criteria) this;
        }

        public Criteria andStnoNotBetween(String value1, String value2) {
            addCriterion("stno not between", value1, value2, "stno");
            return (Criteria) this;
        }

        public Criteria andCnoIsNull() {
            addCriterion("cno is null");
            return (Criteria) this;
        }

        public Criteria andCnoIsNotNull() {
            addCriterion("cno is not null");
            return (Criteria) this;
        }

        public Criteria andCnoEqualTo(String value) {
            addCriterion("cno =", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotEqualTo(String value) {
            addCriterion("cno <>", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThan(String value) {
            addCriterion("cno >", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThanOrEqualTo(String value) {
            addCriterion("cno >=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThan(String value) {
            addCriterion("cno <", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThanOrEqualTo(String value) {
            addCriterion("cno <=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLike(String value) {
            addCriterion("cno like", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotLike(String value) {
            addCriterion("cno not like", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoIn(List<String> values) {
            addCriterion("cno in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotIn(List<String> values) {
            addCriterion("cno not in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoBetween(String value1, String value2) {
            addCriterion("cno between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotBetween(String value1, String value2) {
            addCriterion("cno not between", value1, value2, "cno");
            return (Criteria) this;
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

        public Criteria andStnumIsNull() {
            addCriterion("stnum is null");
            return (Criteria) this;
        }

        public Criteria andStnumIsNotNull() {
            addCriterion("stnum is not null");
            return (Criteria) this;
        }

        public Criteria andStnumEqualTo(Integer value) {
            addCriterion("stnum =", value, "stnum");
            return (Criteria) this;
        }

        public Criteria andStnumNotEqualTo(Integer value) {
            addCriterion("stnum <>", value, "stnum");
            return (Criteria) this;
        }

        public Criteria andStnumGreaterThan(Integer value) {
            addCriterion("stnum >", value, "stnum");
            return (Criteria) this;
        }

        public Criteria andStnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stnum >=", value, "stnum");
            return (Criteria) this;
        }

        public Criteria andStnumLessThan(Integer value) {
            addCriterion("stnum <", value, "stnum");
            return (Criteria) this;
        }

        public Criteria andStnumLessThanOrEqualTo(Integer value) {
            addCriterion("stnum <=", value, "stnum");
            return (Criteria) this;
        }

        public Criteria andStnumIn(List<Integer> values) {
            addCriterion("stnum in", values, "stnum");
            return (Criteria) this;
        }

        public Criteria andStnumNotIn(List<Integer> values) {
            addCriterion("stnum not in", values, "stnum");
            return (Criteria) this;
        }

        public Criteria andStnumBetween(Integer value1, Integer value2) {
            addCriterion("stnum between", value1, value2, "stnum");
            return (Criteria) this;
        }

        public Criteria andStnumNotBetween(Integer value1, Integer value2) {
            addCriterion("stnum not between", value1, value2, "stnum");
            return (Criteria) this;
        }

        public Criteria andStdateIsNull() {
            addCriterion("stdate is null");
            return (Criteria) this;
        }

        public Criteria andStdateIsNotNull() {
            addCriterion("stdate is not null");
            return (Criteria) this;
        }

        public Criteria andStdateEqualTo(Date value) {
            addCriterion("stdate =", value, "stdate");
            return (Criteria) this;
        }

        public Criteria andStdateNotEqualTo(Date value) {
            addCriterion("stdate <>", value, "stdate");
            return (Criteria) this;
        }

        public Criteria andStdateGreaterThan(Date value) {
            addCriterion("stdate >", value, "stdate");
            return (Criteria) this;
        }

        public Criteria andStdateGreaterThanOrEqualTo(Date value) {
            addCriterion("stdate >=", value, "stdate");
            return (Criteria) this;
        }

        public Criteria andStdateLessThan(Date value) {
            addCriterion("stdate <", value, "stdate");
            return (Criteria) this;
        }

        public Criteria andStdateLessThanOrEqualTo(Date value) {
            addCriterion("stdate <=", value, "stdate");
            return (Criteria) this;
        }

        public Criteria andStdateIn(List<Date> values) {
            addCriterion("stdate in", values, "stdate");
            return (Criteria) this;
        }

        public Criteria andStdateNotIn(List<Date> values) {
            addCriterion("stdate not in", values, "stdate");
            return (Criteria) this;
        }

        public Criteria andStdateBetween(Date value1, Date value2) {
            addCriterion("stdate between", value1, value2, "stdate");
            return (Criteria) this;
        }

        public Criteria andStdateNotBetween(Date value1, Date value2) {
            addCriterion("stdate not between", value1, value2, "stdate");
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