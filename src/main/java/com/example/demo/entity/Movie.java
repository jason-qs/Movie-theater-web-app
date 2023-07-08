package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie_table")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(
            name = "user_reservations",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )

    private Set<User> going = new HashSet<>();

    private String name;
    private String Poster;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="theater_id", referencedColumnName = "id")
    private Theater theater;

    @Temporal(TemporalType.DATE)
    private Calendar movieDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date movieTime;

    public Set<User> getGoing() {
        return going;
    }

    public Theater getTheater() {
        return theater;
    }

    public void reserveUser(User user) {
        going.add(user);
    }

    public void assignTheater(Theater theater) {
        this.theater = theater;
    }

}
