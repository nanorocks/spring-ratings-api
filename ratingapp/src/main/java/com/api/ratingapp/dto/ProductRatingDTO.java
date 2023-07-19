package com.api.ratingapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
public class ProductRatingDTO {
    private String name;
    private Double total;
    private Integer slugsFound;

    public ProductRatingDTO(String name, double total, int slugsFound) {
        this.name = name;
        this.total = total;
        this.slugsFound = slugsFound;
    }
}
