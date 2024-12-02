package com.test.echoandrich.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_ID")
    private Long id;

    @Column(name = "REGION_NAME", nullable = false, length = 100)
    private String name;

    private Region(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Region of(Long id, String name) {
        return new Region(id, name);
    }

}

