package com.lin.cangkusp.pojo;

import java.util.ArrayList;
import java.util.List;

public class RolePermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RolePermissionExample() {
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

        public Criteria andRpnoIsNull() {
            addCriterion("rpno is null");
            return (Criteria) this;
        }

        public Criteria andRpnoIsNotNull() {
            addCriterion("rpno is not null");
            return (Criteria) this;
        }

        public Criteria andRpnoEqualTo(Integer value) {
            addCriterion("rpno =", value, "rpno");
            return (Criteria) this;
        }

        public Criteria andRpnoNotEqualTo(Integer value) {
            addCriterion("rpno <>", value, "rpno");
            return (Criteria) this;
        }

        public Criteria andRpnoGreaterThan(Integer value) {
            addCriterion("rpno >", value, "rpno");
            return (Criteria) this;
        }

        public Criteria andRpnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("rpno >=", value, "rpno");
            return (Criteria) this;
        }

        public Criteria andRpnoLessThan(Integer value) {
            addCriterion("rpno <", value, "rpno");
            return (Criteria) this;
        }

        public Criteria andRpnoLessThanOrEqualTo(Integer value) {
            addCriterion("rpno <=", value, "rpno");
            return (Criteria) this;
        }

        public Criteria andRpnoIn(List<Integer> values) {
            addCriterion("rpno in", values, "rpno");
            return (Criteria) this;
        }

        public Criteria andRpnoNotIn(List<Integer> values) {
            addCriterion("rpno not in", values, "rpno");
            return (Criteria) this;
        }

        public Criteria andRpnoBetween(Integer value1, Integer value2) {
            addCriterion("rpno between", value1, value2, "rpno");
            return (Criteria) this;
        }

        public Criteria andRpnoNotBetween(Integer value1, Integer value2) {
            addCriterion("rpno not between", value1, value2, "rpno");
            return (Criteria) this;
        }

        public Criteria andRnoIsNull() {
            addCriterion("rno is null");
            return (Criteria) this;
        }

        public Criteria andRnoIsNotNull() {
            addCriterion("rno is not null");
            return (Criteria) this;
        }

        public Criteria andRnoEqualTo(Integer value) {
            addCriterion("rno =", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoNotEqualTo(Integer value) {
            addCriterion("rno <>", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoGreaterThan(Integer value) {
            addCriterion("rno >", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("rno >=", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoLessThan(Integer value) {
            addCriterion("rno <", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoLessThanOrEqualTo(Integer value) {
            addCriterion("rno <=", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoIn(List<Integer> values) {
            addCriterion("rno in", values, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoNotIn(List<Integer> values) {
            addCriterion("rno not in", values, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoBetween(Integer value1, Integer value2) {
            addCriterion("rno between", value1, value2, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoNotBetween(Integer value1, Integer value2) {
            addCriterion("rno not between", value1, value2, "rno");
            return (Criteria) this;
        }

        public Criteria andPernoIsNull() {
            addCriterion("perno is null");
            return (Criteria) this;
        }

        public Criteria andPernoIsNotNull() {
            addCriterion("perno is not null");
            return (Criteria) this;
        }

        public Criteria andPernoEqualTo(Integer value) {
            addCriterion("perno =", value, "perno");
            return (Criteria) this;
        }

        public Criteria andPernoNotEqualTo(Integer value) {
            addCriterion("perno <>", value, "perno");
            return (Criteria) this;
        }

        public Criteria andPernoGreaterThan(Integer value) {
            addCriterion("perno >", value, "perno");
            return (Criteria) this;
        }

        public Criteria andPernoGreaterThanOrEqualTo(Integer value) {
            addCriterion("perno >=", value, "perno");
            return (Criteria) this;
        }

        public Criteria andPernoLessThan(Integer value) {
            addCriterion("perno <", value, "perno");
            return (Criteria) this;
        }

        public Criteria andPernoLessThanOrEqualTo(Integer value) {
            addCriterion("perno <=", value, "perno");
            return (Criteria) this;
        }

        public Criteria andPernoIn(List<Integer> values) {
            addCriterion("perno in", values, "perno");
            return (Criteria) this;
        }

        public Criteria andPernoNotIn(List<Integer> values) {
            addCriterion("perno not in", values, "perno");
            return (Criteria) this;
        }

        public Criteria andPernoBetween(Integer value1, Integer value2) {
            addCriterion("perno between", value1, value2, "perno");
            return (Criteria) this;
        }

        public Criteria andPernoNotBetween(Integer value1, Integer value2) {
            addCriterion("perno not between", value1, value2, "perno");
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