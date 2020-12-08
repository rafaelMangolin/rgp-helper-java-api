package com.rpghelper.citymaker.repository;


import com.rpghelper.citymaker.domain.CityConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface CityConfigRepository extends MongoRepository<CityConfig,String> {
    CityConfig findByHash(@Param("hash") String hash);
}
