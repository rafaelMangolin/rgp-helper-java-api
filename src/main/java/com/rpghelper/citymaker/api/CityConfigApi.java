package com.rpghelper.citymaker.api;

import com.rpghelper.citymaker.domain.CityConfig;
import com.rpghelper.citymaker.dto.City;
import com.rpghelper.citymaker.service.CityConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityConfigApi {
    @Autowired
    private CityConfigService service;

    @GetMapping("/find-hash/{hash}")
    public CityConfig findHash(@PathVariable String hash){
        return service.findByHash(hash);
    }

    @GetMapping("/generate")
    public City findHash(@RequestBody CityConfig config){
        return service.generateCity(config);
    }
}
