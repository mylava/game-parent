package com.foolox.game.common.util;

import java.util.UUID;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 12/05/2019
 */
public class FooloxUtils {
    private static MD5 md5 = new MD5();
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "") ;
    }

    public static String md5(String str) {
        return md5.getMD5ofStr(md5.getMD5ofStr(str));
    }

}
