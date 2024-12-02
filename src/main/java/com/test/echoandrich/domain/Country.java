package com.test.echoandrich.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "COUNTRY_ID")
    private String countryId;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    private Country(String countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public static Country of(String countryId, String countryName) {
        return new Country(countryId, countryName);
    }
}

