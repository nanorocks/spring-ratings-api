package com.api.ratingapp.seeds;

import com.api.ratingapp.models.Rating;
import com.api.ratingapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;

@Component
public class SeedDataLoader implements CommandLineRunner {

    private final RatingRepository ratingRepository;

    @Autowired
    public SeedDataLoader(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Seed the database with initial data
        seedRatings();
    }

    private void seedRatings() {
        Rating rating1 = new Rating("product-1", "192.168.1.100", 5, new Timestamp(System.currentTimeMillis()));
        Rating rating2 = new Rating("product-1", "192.168.1.101", 4, new Timestamp(System.currentTimeMillis()));

        // Add more Rating objects as needed

        ratingRepository.save(rating1);
        ratingRepository.save(rating2);

        // Save other Ratings to the database
    }
}
