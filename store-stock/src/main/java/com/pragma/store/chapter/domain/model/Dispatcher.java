package com.pragma.store.chapter.domain.model;

public class Dispatcher {
    private Long id;
    private String enterpriseEmail;
    private String country;
    private String city;
    private Person person;

    public Dispatcher(Long id, String enterpriseEmail, String country, String city, Person person) {
        this.id = id;
        this.enterpriseEmail = enterpriseEmail;
        this.country = country;
        this.city = city;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
