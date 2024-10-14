package org.beta.country_service.model;

import lombok.Builder;
import lombok.With;

import java.util.List;

@With
@Builder
public record Country(
        String id,
        String name,
        String capital,
        Integer population,
        Integer area,
        String continent,
        List<String> neighbours
) {

}
