package com.leoman.cache.service;



import com.leoman.cache.CacheService;
import com.leoman.cache.service.impl.*;

import javax.annotation.Resource;


public abstract class AbstractCacheService{

    private CommonMapCache commonMapCache;
    private CommonObjectCache commonObjectCache;
    private CommonStringCache commonStringCache;
    private CommonStringListCache commonStringListCache;
    private CommonObjectListCache commonObjectListCache;


    @Resource(name="redisCacheServiceImpl")
    private CacheService redisCacheService;


    public CommonMapCache getCommonMapCache() {
        if(commonMapCache==null){
            synchronized (this) {
                if(commonMapCache==null){
                    commonMapCache=new CommonMapCacheImpl(redisCacheService);
                }
            }
        }
        return commonMapCache;
    }
    public CommonObjectCache getCommonObjectCache() {
        if(commonObjectCache==null){
            synchronized (this) {
                if(commonObjectCache==null){
                    commonObjectCache=new CommonObjectCacheImpl(redisCacheService);
                }
            }
        }
        return commonObjectCache;
    }
    public CommonStringCache getCommonStringCache() {
        if(commonStringCache==null){
            synchronized (this) {
                if(commonStringCache==null){
                    commonStringCache=new CommonStringCacheImpl(redisCacheService);
                }
            }
        }
        return commonStringCache;
    }
    public CommonStringListCache getCommonStringListCache() {
        if(commonStringListCache==null){
            synchronized (this) {
                if(commonStringListCache==null){
                    commonStringListCache=new CommonStringListCacheImpl(redisCacheService);
                }
            }
        }
        return commonStringListCache;
    }
    public CommonObjectListCache getCommonObjectListCache() {
        if(commonObjectListCache==null){
            synchronized (this) {
                if(commonObjectListCache==null){
                    commonObjectListCache=new CommonObjectListCacheImpl(redisCacheService);
                }
            }
        }
        return commonObjectListCache;
    }

    protected abstract String getKey(String key);



}