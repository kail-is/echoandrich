package com.test.echoandrich.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "JOB_TITLE", nullable = false)
    private String jobTitle;

    @Column(name = "MIN_SALARY")
    private Integer minSalary;

    @Column(name = "MAX_SALARY")
    private Integer maxSalary;

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private List<Employee> employees;

    private Job(String jobId, String jobTitle, Integer minSalary, Integer maxSalary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public static Job of(String jobId, String jobTitle, Integer minSalary, Integer maxSalary) {
        return new Job(jobId, jobTitle, minSalary, maxSalary);
    }

}

