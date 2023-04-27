package com.example.connectdb.service;

import com.example.connectdb.entity.City;
import com.example.connectdb.repository.CityRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogFile;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;
    
    public List<City> findAll() {

        var cities = (List<City>) repository.findAll();

        return cities;
    }
    // FIND BY ID
    public City findById(Long id) {
      Optional<City> city = this.repository.findById(id);
      if (city.isPresent()) {
          return city.get();
      } else {
          return null;
      }
    }
    // CREATE
    public City create(City city) {
      return repository.save(city);
    }
//    UPDATE
    public City update(Long id, City city) {
        Optional<City> _city =  repository.findById(id);
        if(_city.isPresent()){
            City dataResult = _city.get();
            dataResult.setName(city.getName());
            dataResult.setPopulation(city.getPopulation());
            return repository.save(dataResult);
        } else {
            return null;
        }
    }
    // DELETE
    public City deleteById(Long id) {
      repository.deleteById(id);
       return null;
    }
    // DELETE ALL
    public City deleteAll() {
      repository.deleteAll();
      return null;
    }
}