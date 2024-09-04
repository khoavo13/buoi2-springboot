package com.example.buoi2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @GetMapping(value="/city")
    public City getCity(@RequestParam(name = "citycode") int cityCode,
                        @RequestParam(name = "cityname",defaultValue = "Ho Chi Minh") String cityName,
                        @RequestParam(name = "numberdist") String numberDist){

        return new City(cityCode, cityName, numberDist);

    }
}
