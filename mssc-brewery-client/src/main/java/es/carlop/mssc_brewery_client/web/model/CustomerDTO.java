package es.carlop.mssc_brewery_client.web.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CustomerDTO(
        UUID id,
        String name
) { }
