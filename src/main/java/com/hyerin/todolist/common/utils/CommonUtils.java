package com.hyerin.todolist.common.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * <pre>
 *   클래스명 : CommonUtils
 *   설명 : 공통유틸
 * <pre/>
 */
@Component
public class CommonUtils {

    private static HashMap<String, String> initMap;


    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${server.port}")
    private String serverPort;

    @Value("${server-ip-logging-yn}")
    private String serverIpLoggingYn;

    @PostConstruct
    private void init() {
        initMap = new HashMap<String, String>();
        initMap.put("contextPath", contextPath);
        initMap.put("serverPort", serverPort);
        initMap.put("serverIpLoggingYn", serverIpLoggingYn);
    }

    /**
     * <pre>
     *   메소드명 : getServerIP
     *   설명 : server IP 반환
     * <pre/>
     */
    public static String getServerIP() {
        String serverIP = "";
        InetAddress localhost = null;
        try {
            localhost = InetAddress.getLocalHost();
            serverIP = localhost.getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        if("0".equals(initMap.getOrDefault("serverIpLoggingYn", ""))) {
            return "xxx.xxx.xx.xx";
        } else {
            return serverIP;
        }
    }

    public static String getContextPath() {
        return initMap.getOrDefault("contextPath", "");
    }

    public static String getServerPort() {
        return initMap.getOrDefault("serverPort", "");
    }
}
