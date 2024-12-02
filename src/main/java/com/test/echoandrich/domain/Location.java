package com.test.echoandrich.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_ID")
    private Long locationId;

    @Column(name = "STREET_ADDRESS")
    private String streetAddress;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE_PROVINCE")
    private String stateProvince;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    private Location(Long locationId, String streetAddress, String postalCode, String city, String stateProvince, Country country) {
        this.locationId = locationId;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.country = country;
    }

    public static Location of(Long locationId, String streetAddress, String postalCode, String city, String stateProvince, Country country) {
        return new Location(locationId, streetAddress, postalCode, city, stateProvince, country);
    }


}

