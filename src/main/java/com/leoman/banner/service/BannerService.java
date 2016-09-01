package com.leoman.banner.service;


import com.jarvis.cache.annotation.Cache;
import com.leoman.banner.entity.Banner;
import com.leoman.common.service.GenericManager;
import com.leoman.team.entity.Team;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Daisy on 2016/8/4.
 */
public interface BannerService extends GenericManager<Banner> {

//    @Cache(expire=600, autoload=true, key="'banner'+#args[0]", condition="#args[0]>0")
    public List<Banner> findByPosition(Integer position);
}
