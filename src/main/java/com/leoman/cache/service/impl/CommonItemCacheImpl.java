package com.leoman.cache.service.impl;



import com.leoman.cache.CacheService;
import com.leoman.cache.common.item.CacheItem;
import com.leoman.cache.service.CommonItemCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 */
public class CommonItemCacheImpl implements CommonItemCache {

	private static Logger Logger = LoggerFactory.getLogger(CommonItemCacheImpl.class);

	private CacheService cacheService;

	public CommonItemCacheImpl(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public CacheItem get(String key) {
		try {
			CacheItem item = (CacheItem) cacheService.get(key);
			if (item != null) {
				if (cacheService.getResetDate() == null
						|| item.getTimestamp().after(cacheService.getResetDate())) {
					return item;
				}
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void put(String key, CacheItem cacheItem) {
		cacheService.put(key, cacheItem);
	}

    @Override
    public void put(String key, CacheItem obj, int second) {
        cacheService.put(key, obj,second);
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
