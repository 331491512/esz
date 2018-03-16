package com.esuizhen.cloudservice.user.followuppatient.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class ObjectType {

    public static final String module = ObjectType.class.getName();

    public static final Object NULL = new NullObject();


    public static final String LANG_PACKAGE = "java.lang."; // We will test both the raw value and this + raw value
    public static final String SQL_PACKAGE = "java.sql.";   // We will test both the raw value and this + raw value

    @SuppressWarnings("unchecked")
    public static boolean isEmpty(Object value) {
        if (value == null) return true;

        if (value instanceof String) return ((String) value).length() == 0;
        if (value instanceof Collection) return ((Collection<? extends Object>) value).size() == 0;
        if (value instanceof Map) return ((Map<? extends Object, ? extends Object>) value).size() == 0;
        if (value instanceof CharSequence) return ((CharSequence) value).length() == 0;
//        if (value instanceof IsEmpty) return ((IsEmpty) value).isEmpty();

        // These types would flood the log
        // Number covers: BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, Short
        if (value instanceof Boolean) return false;
        if (value instanceof Number) return false;
        if (value instanceof Character) return false;
        if (value instanceof java.util.Date) return false;

        return false;
    }

    @SuppressWarnings("serial")
    public static final class NullObject implements Serializable {
        public NullObject() { }

        @Override
        public String toString() {
            return "ObjectType.NullObject";
        }

        @Override
        public int hashCode() {
            return toString().hashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof NullObject) {
                // should do equality of object? don't think so, just same type
                return true;
            } else {
                return false;
            }
        }
    }
}
