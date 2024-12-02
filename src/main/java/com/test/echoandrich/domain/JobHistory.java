package com.test.echoandrich.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "job_history")
public class JobHistory {

    @EmbeddedId
    private JobHistoryId jobHistoryId;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "JOB_ID")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;


    private JobHistory(Employee employee, LocalDate startDate, LocalDate endDate, Job job, Department department) {
        this.jobHistoryId = new JobHistoryId(employee.getEmployeeId(), startDate);
        this.endDate = endDate;
        this.job = job;
        this.department = department;
    }

    public static JobHistory of(Employee employee, LocalDate startDate, LocalDate endDate, Job job, Department department) {
        return new JobHistory(employee, startDate, endDate, job, department);
    }

}

