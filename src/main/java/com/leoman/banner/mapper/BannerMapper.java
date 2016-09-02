package com.leoman.banner.mapper;

import com.jarvis.cache.annotation.Cache;
import com.leoman.banner.entity.Banner;

import java.util.List;

public interface BannerMapper {

    @Cache(expire=600, autoload=true, key="'getBannerList'+#args[0]")
    List<Banner> getBannerList(Integer id);
}
