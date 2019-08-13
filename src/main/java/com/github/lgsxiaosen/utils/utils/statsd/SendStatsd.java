package com.github.lgsxiaosen.utils.utils.statsd;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author xiaosen
 * @date 2019/4/1 16:43
 * @description
 */
public class SendStatsd {
    private static final Logger logger = LoggerFactory.getLogger(SendStatsd.class);

    public static void sendMessage(String path, String value, String statsdIp, Integer port){
        if (StringUtils.isBlank(statsdIp)||port==null){
            return;
        }
        try(DatagramSocket s = new DatagramSocket()) {
            String data = path + ":" + value;
            byte[] bs = data.getBytes();
            logger.debug("发送数据");
            DatagramPacket dp = new DatagramPacket(bs, bs.length, InetAddress.getByName(statsdIp), port);
            s.send(dp);
        } catch (Exception e) {
            logger.error("发送失败:{}", e.getMessage());
        }
    }

}
