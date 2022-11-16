package com.pragma.store.chapter.domain.model;

public class Provider {
    private Long id;
    private String country;
    private String city;
    private String addressMain;
    private Person person;

    public Provider(Long id, String country, String city, String addressMain, Person person) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.addressMain = addressMain;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressMain() {
        return addressMain;
    }

    public void setAddressMain(String addressMain) {
        this.addressMain = addressMain;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
