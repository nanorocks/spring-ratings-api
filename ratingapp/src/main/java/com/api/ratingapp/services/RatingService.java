package com.api.ratingapp.services;

import com.api.ratingapp.dto.ProductRatingDTO;
import com.api.ratingapp.models.Rating;
import com.api.ratingapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id).orElse(null);
    }

    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(Long id, Rating updatedRating) {
        Rating existingRating = ratingRepository.findById(id).orElse(null);
        if (existingRating != null) {
            existingRating.setSlug(updatedRating.getSlug());
            existingRating.setIp(updatedRating.getIp());
            existingRating.setRate(updatedRating.getRate());
            // Update other fields as needed
            return ratingRepository.save(existingRating);
        }
        return null;
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

    public List<Object[]> getAverageRatingAndQuantityBySlug() {
        return ratingRepository.getAverageRatingAndQuantityBySlug();
    }

    public ProductRatingDTO getAverageRatingAndQuantityBySlug(String slug) {
        List<Object[]> ratings = ratingRepository.findAverageRatingAndQuantityBySlug(slug);

        if (!ratings.isEmpty()) {
            Object[] ratingData = ratings.get(0);
            String productSlug = (String) ratingData[0];
            double averageRating = (Double) ratingData[1];
            int slugsFound = ((Long) ratingData[2]).intValue();
            return new ProductRatingDTO(productSlug, averageRating, slugsFound);
        }

        return null;
    }

    public Rating createRatingBySlugAndIp(Rating rating) {
        String slug = rating.getSlug();
        String ip = rating.getIp();

        Optional<Rating> existingRating = ratingRepository.findRatingBySlugAndIp(slug, ip);
        // Rating with the same IP and slug already exists, you can choose to update or return an error
        // For simplicity, we'll just return the existing rating
        // No rating with the same IP and slug exists, save the new rating
        return existingRating.orElseGet(() -> ratingRepository.save(rating));
    }

    public void removeRatingByIp(String ip) {
        List<Rating> existingRatings = ratingRepository.findByIp(ip);

        for (Rating rating : existingRatings) {
            ratingRepository.delete(rating);
        }
    }
}
