package com.test.echoandrich.domain.repository;

import com.test.echoandrich.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}