package es.carlop.mssc_brewery_client.web.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public record BeerDTO(
        UUID id,
        String beerName,
        String beerStyle,
        Long upc
) {
}
