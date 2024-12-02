package com.test.echoandrich.domain.repository;

import com.test.echoandrich.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}