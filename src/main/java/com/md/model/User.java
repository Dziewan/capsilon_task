package com.md.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "dealer_user")
public class User implements Serializable {

    public User() {}

    private User(final Builder builder) {
        this.login = builder.login;
        this.password = builder.password;
        this.pesel = builder.pesel;
        this.email = builder.email;
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

    @Column(name = "email")
    private Integer email;

    public Long getId() {
        return id;
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

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
        this.email = email;
    }


    public static class Builder {

        private String login;
        private String password;
        private String pesel;
        private Integer email;

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

        public Builder email(final Integer email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
}
