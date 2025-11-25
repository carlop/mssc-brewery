package es.carlop.mssc_brewery_client.web.client;

import es.carlop.mssc_brewery_client.web.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDTO beerDTO = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDTO);
    }
}