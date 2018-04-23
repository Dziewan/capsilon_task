package com.md.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "klienci")
public class Customer implements Serializable {

    public Customer() {}

    private Customer(final Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.pesel = builder.pesel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_klient")
    private Long id;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String surname;

    @Column(name = "pesel")
    private String pesel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public static class Builder {

        private String name;
        private String surname;
        private String pesel;

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder surname(final String surname) {
            this.surname = surname;
            return this;
        }

        public Builder pesel(final String pesel) {
            this.pesel = pesel;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
