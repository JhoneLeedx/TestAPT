package com.jhonlee.aptlib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dengxin
 * @Description TODO
 * @date 2018/4/17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface HellowWord {
}
