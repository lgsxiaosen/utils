package com.github.lgsxiaosen.utils.utils.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author sen
 * 2019/11/1 15:18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({SpringScanConfig.class})
public @interface EnableXiaosenUtils {
}
