package com.bontade.web.service.rest.controller;

import com.bontade.web.service.rest.model.City;
import com.bontade.web.service.rest.model.Greeting;
import com.bontade.web.service.rest.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zarebaa on 18/05/2016.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/cities")
    public List<City> cities(@RequestParam(value = "name", defaultValue = "World") String name) {
        addCities(10);
        return cityRepository.findAll();
    }

    private void addCities(int amount) {
        City cityToAdd = null;
        for (int i = 0; i < amount; i++) {
            cityToAdd = new City("city name " + i, "city State " + 1);
            cityRepository.save(cityToAdd);
        }
    }
}
