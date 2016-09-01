package com.leoman.banner.dao;


import com.jarvis.cache.annotation.Cache;
import com.leoman.banner.entity.Banner;
import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.team.entity.Team;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Daisy on 2016/8/4.
 */
public interface BannerDao extends IBaseJpaRepository<Banner> {

    @Cache(expire=600, autoload=true, key="'banner'+#args[0]")
    @Query("select a from Banner a where a.position = ?1")
    public List<Banner> findByPosition(Integer position);
}
