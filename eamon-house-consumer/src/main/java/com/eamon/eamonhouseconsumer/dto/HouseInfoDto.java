package com.eamon.eamonhouseconsumer.dto;

public class HouseInfoDto {
    private Long id;

    private String city;

    private String region;

    private String name;


    public HouseInfoDto(Long id, String city, String region, String name) {
        super();
        this.id = id;
        this.city = city;
        this.region = region;
        this.name = name;
    }

    public HouseInfoDto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
