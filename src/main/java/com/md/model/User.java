package com.md.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "user")
public class User {

    public User() {}

    private User(final Builder builder) {
        this.login = builder.login;
        this.password = builder.password;
        this.pesel = builder.pesel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "pesel")
    private String pesel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


    public static class Builder {

        private String login;
        private String password;
        private String pesel;

        public Builder login(final String login) {
            this.login = login;
            return this;
        }

        public Builder password(final String password) {
            this.password = password;
            return this;
        }

        public Builder pesel(final String pesel) {
            this.pesel = pesel;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
}
