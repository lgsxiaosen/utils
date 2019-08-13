package com.github.lgsxiaosen.utils.utils.aop;

import com.github.lgsxiaosen.utils.utils.config.StatsdProperties;
import com.github.lgsxiaosen.utils.utils.statsd.SendStatsd;
import com.github.lgsxiaosen.utils.utils.statsd.StatsdAnnotation;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xiaosen
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private StatsdProperties statsdProperties;

    @Autowired
    public LogAspect(StatsdProperties statsdProperties){
        this.statsdProperties = statsdProperties;
    }

    @Around("@annotation(inter)")
    public Object sendUseTime(ProceedingJoinPoint joinPoint, StatsdAnnotation inter) throws Throwable{
        Object object = null;
        long start = System.currentTimeMillis();
        try {
            object = joinPoint.proceed();
        }catch (Throwable e){
            logger.error("切面执行异常：{}", e.getMessage());
            throw e;
        }
        long useTime = System.currentTimeMillis()-start;
        String timer = useTime + "|ms";
        // 发送时间给监控平台
        if (StringUtils.isNotBlank(inter.path())){
            SendStatsd.sendMessage(inter.path(), timer, statsdProperties.getIp(), statsdProperties.getPort());
            if (inter.count()){
                SendStatsd.sendMessage(inter.path()+".counter", "1|c", statsdProperties.getIp(), statsdProperties.getPort());
            }
        }
        return object;
    }


}
