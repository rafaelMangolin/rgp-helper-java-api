package com.rpghelper.citymaker.service;

import com.rpghelper.citymaker.domain.CityConfig;
import com.rpghelper.citymaker.dto.City;
import com.rpghelper.citymaker.repository.CityConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityConfigService {

    @Autowired
    private CityConfigRepository repository;

    public CityConfig findByHash(String hash){
        return repository.findByHash(hash);
    }

    public City generateCity(CityConfig config){
        CityConfig oldConfig = repository.findByHash(config.getHash());
        repository.delete(oldConfig);
        repository.save(config);
        return new City(config);
    }


}
