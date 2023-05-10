package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.repositories.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);
    private CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City create(City city) {
        return repository.save(city);
    }

    @Override
    public City read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public City update(City city) {
        return repository.save(city);
    }

    @Override
    public void delete(Long id) {
        repository.delete(read(id));
    }

    @Override
    public List<City> readAll() {
        return repository.findAll();
    }

    public List<City> findByName(String name) {
        return repository.findByName(name);
    }

    public List<City> findAllCapitals() {
        return repository.findByIsCapitalTrue();
    }


}
