package com.api.ratingapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false)
    private String ip;

    @Column(nullable = false)
    private int rate;

    @Column(nullable = false)
    private Timestamp timestamp;

    public Rating(String slug, String ip, int rate, Timestamp timestamp) {
        this.slug = slug;
        this.ip = ip;
        this.rate = rate;
        this.timestamp = timestamp;
    }
}
