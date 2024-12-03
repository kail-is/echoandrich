package com.test.echoandrich.domain.repository;

import com.test.echoandrich.domain.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {

    List<JobHistory> findByJobHistoryId_EmployeeId(Long employeeId);

    Optional<JobHistory> findFirstByJobHistoryId_EmployeeIdOrderByJobHistoryId_StartDateDesc(Long employeeId);

}