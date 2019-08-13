package com.github.lgsxiaosen.utils.utils;

import net.qihoo.qconf.Qconf;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaosen
 */
public class QconfUtils {
    private static final Logger logger = LoggerFactory.getLogger(QconfUtils.class);

    /**
     * @author xiaosen
     * 获取所有地址
     */
    public static List<String> getAllHost(String qconf){
        List<String> allHost = new ArrayList<>();
        if (StringUtils.isEmpty(qconf)){
            return allHost;
        }
        try {
            allHost = Qconf.getAllHost(qconf);
        }catch (Exception e){
            logger.error("获取所有qconf地址失败, {}", e.getMessage());
        }
        return allHost;
    }

    /**
     * @author xiaosen
     * 获取地址
     */
    public static String getHost(String qconf){
        String host = "";
        if (StringUtils.isEmpty(qconf)){
            return host;
        }
        try {
            host = Qconf.getHost(qconf);
        }catch (Exception e){
            logger.error("获取qconf地址失败, {}", e.getMessage());
        }
        return host;
    }

    public static List<String> getDbInfo(String qconf, String flag){
        List<String> dataBase = new ArrayList<>();
        if (StringUtils.isEmpty(qconf)|| StringUtils.isEmpty(flag)){
            return dataBase;
        }
        try {
            String databaseHost = Qconf.getHost(qconf+"/"+flag);
            String username = Qconf.getConf(qconf+"/username");
            String password = Qconf.getConf(qconf+"/password");
            dataBase.add(databaseHost);
            dataBase.add(username);
            dataBase.add(password);
        }catch (Exception e){
            logger.error("获取数据库qconf地址失败, {}", e.getMessage());
        }
        return dataBase;
    }

    public static String getQconf(String qconf){
        String conf = "";
        if (StringUtils.isEmpty(qconf)){
            return conf;
        }
        try {
            conf = Qconf.getConf(qconf);
        }catch (Exception e){
            logger.error("get_conf失败：{}", e.getMessage());
        }
        return conf;
    }





}
