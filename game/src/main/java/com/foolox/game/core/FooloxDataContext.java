package com.foolox.game.core;

import org.springframework.context.ApplicationContext;

/**
 * comment: 数据上下文
 *
 * @author: lipengfei
 * @date: 06/05/2019
 */
public class FooloxDataContext {
    //socket server状态
    private static boolean serverRunning = false;

    private static ApplicationContext applicationContext ;
    //租户
    public static String SYSTEM_ORGI = "foolox" ;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        FooloxDataContext.applicationContext = applicationContext;
    }

    public static boolean isServerRunning() {
        return serverRunning;
    }

    public static void setServerRunning(boolean serverRunning) {
        FooloxDataContext.serverRunning = serverRunning;
    }
}
