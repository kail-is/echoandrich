package com.test.echoandrich.domain.repository;

import com.test.echoandrich.domain.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {

    List<JobHistory> findByJobHistoryId_EmployeeId(Long employeeId);

}