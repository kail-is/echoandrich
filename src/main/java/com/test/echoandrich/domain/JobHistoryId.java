package com.test.echoandrich.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class JobHistoryId implements Serializable {
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Column(name = "START_DATE")
    private LocalDate startDate;

    public JobHistoryId(Long employeeId, LocalDate startDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
    }
}
