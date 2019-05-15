package com.foolox.game.common.util.cache.hazelcast;

import com.foolox.game.common.util.cache.CacheBean;
import com.foolox.game.common.util.cache.hazelcast.impl.ApiUserCache;
import com.foolox.game.core.FooloxDataContext;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 14/05/2019
 */
public class HazelcastContext {

    /**
     * 服务类型枚举
     *
     * @author admin
     */
    public enum CacheServiceEnum {
        HAZLCAST_CLUSTER_AGENT_USER_CACHE,
        HAZLCAST_CLUSTER_AGENT_STATUS_CACHE,
        HAZLCAST_CLUSTER_QUENE_USER_CACHE,
        HAZLCAST_ONLINE_CACHE,
        GAME_PLAYERS_CACHE,
        HAZLCAST_CULUSTER_SYSTEM,
        HAZLCAST_GAMEROOM_CACHE,
        API_USER_CACHE,
        QUENE_CACHE,
        HAZLCAST_TASK_CACHE,
        HAZLCAST_GAME_CACHE;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public static CacheBean getApiUserCacheBean() {
        return FooloxDataContext.getApplicationContext().getBean(ApiUserCache.class).getCacheBean(CacheServiceEnum.API_USER_CACHE.toString()) ;
    }
}
