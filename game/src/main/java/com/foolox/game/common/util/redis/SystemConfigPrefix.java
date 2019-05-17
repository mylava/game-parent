package com.foolox.game.common.util.redis;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 16/05/2019
 */
public class SystemConfigPrefix extends BasePrefix{
    private SystemConfigPrefix(String prefix) {
        super(prefix);
    }

    public static final SystemConfigPrefix games = new SystemConfigPrefix("games");
}
