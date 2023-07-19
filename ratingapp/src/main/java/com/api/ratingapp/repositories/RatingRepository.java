package com.api.ratingapp.repositories;

import com.api.ratingapp.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT r.slug, AVG(r.rate) as total, COUNT(r.slug) as quantity FROM Rating r GROUP BY r.slug ORDER BY total DESC")
    List<Object[]> getAverageRatingAndQuantityBySlug();

    @Query(value = "SELECT slug, AVG(rate) as total, COUNT(slug) as quantity " +
            "FROM rating WHERE slug = :slug " +
            "GROUP BY slug", nativeQuery = true)
    List<Object[]> findAverageRatingAndQuantityBySlug(String slug);

    @Query("SELECT r FROM Rating r WHERE r.slug = :slug AND r.ip = :ip")
    Optional<Rating> findRatingBySlugAndIp(String slug, String ip);

    List<Rating> findByIp(String ip);
}
