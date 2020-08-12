package com.test.persistence;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String name() default "";
    String dataType()default "";
    boolean unique() default false;
    boolean nullable() default true;
    int length() default 255;
}
