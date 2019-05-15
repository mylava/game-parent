package com.foolox.game.common.util.cache.hazelcast.impl;

import com.foolox.game.common.util.cache.CacheBean;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.locks.Lock;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 14/05/2019
 */
@Service("api_user_cache")
public class ApiUserCache implements CacheBean {
    @Autowired
    public HazelcastInstance hazelcastInstance;
    private String cacheName;

    @Override
    public CacheBean getCacheBean(String cacheName) {
        this.cacheName = cacheName;
        return this;
    }

    @Override
    public void put(String key, Object value) {
        hazelcastInstance.getMap(getName()).put(key, value);
    }

    @Override
    public void clear() {
        hazelcastInstance.getMap(getName()).clear();
    }

    @Override
    public Object delete(String key) {
        return hazelcastInstance.getMap(getName()).remove(key);
    }

    @Override
    public void update(String key, Object value) {
        hazelcastInstance.getMap(getName()).put(key, value);
    }

    @Override
    public Object getCacheObject(String key) {
        return hazelcastInstance.getMap(getName()).get(key);
    }

    public String getName() {
        return cacheName;
    }

    //	@Override
    public void service() throws Exception {

    }

    @Override
    public Collection<?> getAllCacheObject() {
        return hazelcastInstance.getMap(getName()).keySet();
    }

    @Override
    public Object getCacheObject(String key, Object defaultValue) {
        return getCacheObject(key);
    }

    @Override
    public Object getCache() {
        return hazelcastInstance.getMap(cacheName);
    }

    @Override
    public Lock getLock(String lock) {
        return hazelcastInstance.getLock(lock);
    }

    @Override
    public long getSize() {
        return hazelcastInstance.getMap(getName()).size();
    }

    @Override
    public long getAtomicLong(String cacheName) {
        return hazelcastInstance.getAtomicLong(getName()).incrementAndGet();
    }

    @Override
    public void setAtomicLong(String cacheName, long start) {
        hazelcastInstance.getAtomicLong(getName()).set(start);
    }
}
