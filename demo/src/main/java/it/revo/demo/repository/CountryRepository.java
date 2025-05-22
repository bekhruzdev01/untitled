package it.revo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.revo.demo.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

    
}
