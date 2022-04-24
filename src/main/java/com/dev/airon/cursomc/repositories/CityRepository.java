package com.dev.airon.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.airon.cursomc.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
