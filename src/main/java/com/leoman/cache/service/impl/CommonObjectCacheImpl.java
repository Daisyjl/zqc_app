package com.leoman.cache.service.impl;


import com.leoman.cache.CacheService;
import com.leoman.cache.service.CommonObjectCache;

/**
 * 
 * 
 */
public class CommonObjectCacheImpl implements CommonObjectCache {
	
	private CacheService cacheService;

	public CommonObjectCacheImpl(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public Object get(String key) {
		return cacheService.get(key);
	}

	@Override
	public void put(String key, Object obj) {
		cacheService.put(key, obj);
	}

    @Override
    public void put(String key, Object obj, int second) {

    }

    @Override
	public void remove(String key) {
		cacheService.remove(key);
	}

	@Override
	public boolean contains(String key) {
		if (cacheService.containsKey(key)) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean checkKeyExisted(String key) {
		return cacheService.checkKeyExisted(key);
	}
	
}
