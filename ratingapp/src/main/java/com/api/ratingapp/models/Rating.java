package com.api.ratingapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Slug cannot be blank")
    @Column(nullable = false)
    private String slug;

    @NotBlank(message = "IP cannot be blank")
    @Column(nullable = false)
    private String ip;

    @NotNull(message = "Rate cannot be null")
    @Min(value = 1, message = "Rate must be at least 1")
    @Max(value = 5, message = "Rate cannot be more than 5")
    @Column(nullable = false)
    private int rate;

    @NotNull(message = "Timestamp cannot be null")
    @Column(nullable = false)
    private Timestamp timestamp;

    public Rating(String slug, String ip, int rate, Timestamp timestamp) {
        this.slug = slug;
        this.ip = ip;
        this.rate = rate;
        this.timestamp = timestamp;
    }
}
