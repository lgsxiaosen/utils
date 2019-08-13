package com.github.lgsxiaosen.utils.utils.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaosen
 * @date 2019/6/3 16:49
 * @description
 */
@Configuration
@ConfigurationProperties(prefix = "statsd.value")
public class StatsdProperties {

    private String ip;

    private Integer port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
