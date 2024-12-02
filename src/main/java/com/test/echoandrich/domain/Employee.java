package com.test.echoandrich.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE", nullable = false)
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "JOB_ID", nullable = false)
    private Job job;

    @Column(name = "SALARY")
    private Double salary;

    @Column(name = "COMMISSION_PCT")
    private Double commissionPct;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    private Employee(Long employeeId, String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Job job, Double salary, Double commissionPct, Employee manager, Department department) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.job = job;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.manager = manager;
        this.department = department;
    }

    public static Employee of(Long employeeId, String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Job job, Double salary, Double commissionPct, Employee manager, Department department) {
        return new Employee(employeeId, firstName, lastName, email, phoneNumber, hireDate, job, salary, commissionPct, manager, department);
    }

    public void updateSalary(Double salary) {
        this.salary = salary;
    }
}

