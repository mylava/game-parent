package com.foolox.game.common.util.cache;

import java.util.Collection;
import java.util.concurrent.locks.Lock;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 14/05/2019
 */
public interface CacheBean {

    void put(String key, Object value);

    void clear();

    Object delete(String key);

    void update(String key, Object object);

    Object getCacheObject(String key);

    Object getCacheObject(String key, Object defaultValue);

    Collection<?> getAllCacheObject();

    CacheBean getCacheBean(String cacheName);

    Object getCache();

    Lock getLock(String lock);

    long getSize();

    long getAtomicLong(String cacheName);

    void setAtomicLong(String cacheName, long start);    //初始化 发号器
}
