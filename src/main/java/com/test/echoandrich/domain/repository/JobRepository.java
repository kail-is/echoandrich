package com.test.echoandrich.domain.repository;

import com.test.echoandrich.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
}