package com.test.echoandrich.web.api;

public enum DentistRegion {

    DG("대구"),
    DJ("대전"),
    KG("경기");

    private final String regionName;

    DentistRegion(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

}
