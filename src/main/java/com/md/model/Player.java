package com.md.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "table")
public class Player {

    public Player() {}

    private Player(final Builder builder) {
        this.state = builder.state;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "player_state")
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static class Builder {

        private String state;

        public Builder state(final String state) {
            this.state = state;
            return this;
        }

        public Player build() {
            return new Player(this);
        }

    }
}
