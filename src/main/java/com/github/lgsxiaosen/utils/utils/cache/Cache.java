package com.github.lgsxiaosen.utils.utils.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaosen
 * 简单的java缓存
 */
public class Cache {
    private static Cache cache;

    private static class BluedCacheInner{
        private static final Cache CACHE = new Cache();
    }

    private Cache(){
        if (cache != null){
            throw new RuntimeException("配置缓存异常");
        }
    }

    private static final Map<String, Object> CACHE = new ConcurrentHashMap<>();

    public static Cache getCache(){
        return BluedCacheInner.CACHE;
    }

    public Object put(String k, Object v){
        return CACHE.put(k, v);
    }

    public Object get(String k){
        return CACHE.get(k);
    }

    public void clear(){
        CACHE.clear();
    }

    public Object remove(String k){
        return CACHE.remove(k);
    }

    public boolean contains(String k){
         return CACHE.containsKey(k);
    }

}