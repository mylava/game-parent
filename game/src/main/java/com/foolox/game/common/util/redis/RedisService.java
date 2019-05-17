package com.foolox.game.common.util.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 21/08/2018
 */
@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 存数据
     * @param prefix
     * @param key
     * @param value
     * @return
     */
    public <T> String set(KeyPrefix prefix, String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String result = jedis.setex(prefix.getPrefix()+":"+key, prefix.getExpire(), value);
            return  result;
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     *
     * @param prefix
     * @param key
     * @return
     */
    public String get(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return  jedis.get(prefix.getPrefix()+":"+key);
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }
    /**
     * 取数据
     * @param prefix
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = jedis.get(prefix.getPrefix()+":"+key);
            T t = jsonString2Bean(str, clazz);
            return  t;
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }


    /**
     * 存数据
     * @param prefix
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> String set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = bean2JsonString(value);
            if (null == str) {
                return "";
            }
            String result = jedis.setex(prefix.getPrefix()+":"+key, prefix.getExpire(), str);
            return  result;
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * 判断key是否存在
     * @param prefix
     * @param key
     * @return
     */
    public Boolean exists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(prefix.getPrefix()+":"+key);
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * 递增
     * @param prefix
     * @param key
     * @return
     */
    public Long incr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Long incr = jedis.incr(prefix.getPrefix() + ":" + key);
            return  incr;
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * 递减
     * @param prefix
     * @param key
     * @return
     */
    public Long decr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Long incr = jedis.decr(prefix.getPrefix() + ":" + key);
            return  incr;
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * 更新过期时间
     * @param prefix
     * @param key
     * @return
     */
    public void updateExpire(KeyPrefix prefix, String key) {
        if (exists(prefix,key)) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.expire(prefix.getPrefix() + ":" + key, prefix.getExpire());
            } finally {
                if (null != jedis) {
                    jedis.close();
                }
            }
        }
    }

    /**
     * 返回指定Key的剩余生存时间
     * @param prefix
     * @param key
     * @return
     */
    public Long ttl(KeyPrefix prefix, String key) {
        if (exists(prefix,key)) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                return jedis.ttl(prefix.getPrefix() + ":" + key);
            } finally {
                if (null != jedis) {
                    jedis.close();
                }
            }
        }
        return null;
    }

    /**
     * 存hash
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hset(KeyPrefix prefix, String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hset(prefix.getPrefix() + ":" + key,field,value);
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * 取Hash
     * @param key
     * @param field
     * @return
     */
    public String hget(KeyPrefix prefix, String key, String field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hget(prefix.getPrefix() + ":" + key,field);
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * 删除hash 中对应的多个field
     * @param key
     * @param field
     * @return
     */
    public Long hdel(KeyPrefix prefix, String key, String... field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hdel(prefix.getPrefix() + ":" + key,field);
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * hash中是否存在field
     * @param key
     * @param field
     * @return
     */
    public Boolean hexists(KeyPrefix prefix, String key, String field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hexists(prefix.getPrefix() + ":" + key,field);
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * 获取hash中指定key的所有值
     * @param prefix
     * @param key
     * @return
     */
    public Map<String, String> hgetAll(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hgetAll(prefix.getPrefix() + ":" + key);
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * 获取hash中指定key的所有 field
     * @param prefix
     * @param key
     * @return
     */
    public Set<String> hkeys(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hkeys(prefix.getPrefix() + ":" + key);
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * 获取hash中指定key的所有 value
     * @param prefix
     * @param key
     * @return
     */
    public List<String> hvals(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hvals(prefix.getPrefix() + ":" + key);
        }finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }


    /**
     * 删除指定key
     * @param key
     * @return
     */
    public Long del(KeyPrefix prefix, String key) {
        if (exists(prefix,key)) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                Long del = jedis.del(prefix.getPrefix() + ":" + key);
                return del;
            } finally {
                if (null != jedis) {
                    jedis.close();
                }
            }
        }
        return null;
    }




    private <T> String bean2JsonString(T value) {
        if (null == value) {
            return null;
        }
        return JSON.toJSONString(value);
    }

    private <T> T jsonString2Bean(String str, Class<T> clazz) {
        if (null == str || str.length()<=0 || null == clazz) {
            return null;
        }
        if (clazz==String.class) {
            return (T) str;
        }
        return  JSON.toJavaObject(JSON.parseObject(str),clazz);
    }


}
