package com.github.lgsxiaosen.utils.utils.statsd;


import java.lang.annotation.*;

/**
 * @author xiaosen
 * @date 2019/4/1 16:38
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface StatsdAnnotation {

    String path();

    boolean count() default false;

    boolean sets() default false;

}
