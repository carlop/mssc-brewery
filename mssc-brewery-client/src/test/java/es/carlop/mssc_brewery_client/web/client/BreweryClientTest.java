package es.carlop.mssc_brewery_client.web.client;

import es.carlop.mssc_brewery_client.web.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
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

    @Test
    void testSaveNewBeer() {
        //given
        BeerDTO beerDTO = BeerDTO.builder()
                .beerName("New Beer")
                .beerStyle("IPA")
                .build();

        URI uri = breweryClient.saveNewBeer(beerDTO);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDTO beerDTO = BeerDTO.builder()
                .beerName("Updated Beer Name")
                .beerStyle("Stout")
                .build();

        breweryClient.updateBeer(UUID.randomUUID(), beerDTO);
    }

}