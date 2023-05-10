package com.hitema.jee.controllers;


import com.hitema.jee.entities.City;
import com.hitema.jee.services.CityService;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CItyController {

    private static final Logger log = LogManager.getLogger(CItyController.class);
    private CityService service;

    public CItyController(CityService service) {
        this.service = service;
    }

    @PostConstruct
    private void check() {
        log.info("Check postconstruct called service Up : "+(service!=null?"Yes":"No"));
    }

    @GetMapping("/cities")
    public ModelAndView getCities() {
        List<City> cities = service.readAll();
        return new ModelAndView("cities","cities",cities);
    }
}
