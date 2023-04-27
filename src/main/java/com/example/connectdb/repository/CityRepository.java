package com.example.connectdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.connectdb.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}