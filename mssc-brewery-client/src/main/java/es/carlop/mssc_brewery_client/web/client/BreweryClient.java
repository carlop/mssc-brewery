package es.carlop.mssc_brewery_client.web.client;

import es.carlop.mssc_brewery_client.web.model.BeerDTO;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreInvalidFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer";
    @Setter
    private String apiHost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID id) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + "/" + id.toString(), BeerDTO.class);
    }

    public URI saveNewBeer(BeerDTO beerDTO) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDTO);
    }

    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        restTemplate.put(apiHost + BEER_PATH_V1 + "/" + beerId.toString(), beerDTO);
    }

}
