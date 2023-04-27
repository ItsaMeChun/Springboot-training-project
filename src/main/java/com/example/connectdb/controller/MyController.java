package com.example.connectdb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.connectdb.entity.City;
import com.example.connectdb.service.CityService;
import com.fasterxml.jackson.core.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/showCities")
public class MyController {

    @Autowired
//    private ICityService cityService;
    private CityService cityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<City> findCities() {

        var cities = cityService.findAll();

        return cities;
    }
//    Find BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public  City getCity(@PathVariable("id") Long id) throws Exception {
      City city = this.cityService.findById(id);
      return city;
    }
//    CREATE
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<City> create(@RequestBody City city) {
        try {
            cityService.create(city);
            return new ResponseEntity<>(city, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    UPDATE
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<City> update(@PathVariable("id") Long id, @RequestBody City city) {
        try {
            cityService.update(id, city);
            return new ResponseEntity<>(city, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    DELETE BY ID
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id) {
      try {
        if(cityService.deleteById(id) == null) {
          return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        else {
          return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      } catch(Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
//    DELETE ALL
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAll() {
      try {
        if(cityService.deleteAll() == null) {
          return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        else {
          return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      } catch(Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
}