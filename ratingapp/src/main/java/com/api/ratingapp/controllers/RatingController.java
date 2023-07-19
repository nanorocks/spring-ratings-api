package com.api.ratingapp.controllers;

import com.api.ratingapp.dto.ProductRatingDTO;
import com.api.ratingapp.models.Rating;
import com.api.ratingapp.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable Long id) {
        Rating rating = ratingService.getRatingById(id);
        if (rating != null) {
            return ResponseEntity.ok(rating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating newRating) {
        Rating createdRating = ratingService.createRating(newRating);
        return ResponseEntity.ok(createdRating);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable Long id, @RequestBody Rating updatedRating) {
        Rating rating = ratingService.updateRating(id, updatedRating);
        if (rating != null) {
            return ResponseEntity.ok(rating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/average")
    public ResponseEntity<List<ProductRatingDTO>> getAverageRatingAndQuantityBySlug() {
        List<Object[]> averageRatings = ratingService.getAverageRatingAndQuantityBySlug();

        // Create a list of ProductRatingDTO with the desired format
        List<ProductRatingDTO> response = new ArrayList<>();
        for (Object[] ratingData : averageRatings) {
            String slug = (String) ratingData[0];
            double averageRating = (Double) ratingData[1];
            int slugsFound = ((Long) ratingData[2]).intValue();
            ProductRatingDTO productRatingDTO = new ProductRatingDTO(slug, averageRating, slugsFound);
            response.add(productRatingDTO);
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/average/{slug}")
    public ResponseEntity<ProductRatingDTO> getAverageRatingAndQuantityBySlug(@PathVariable String slug) {
        ProductRatingDTO averageRating = ratingService.getAverageRatingAndQuantityBySlug(slug);
        if (averageRating != null) {
            return ResponseEntity.ok(averageRating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/unique")
    public ResponseEntity<Rating> createUniqueRatingBySlugAndIp(@RequestBody Rating rating) {
        Rating createdRating = ratingService.createRatingBySlugAndIp(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
    }

    @DeleteMapping("/remove-by-ip")
    public ResponseEntity<Void> removeRatingByIp(@RequestParam String ip) {
        ratingService.removeRatingByIp(ip);
        return ResponseEntity.noContent().build();
    }
}
