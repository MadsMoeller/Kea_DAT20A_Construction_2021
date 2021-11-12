package edu.kea.paintings;

import edu.kea.paintings.controllers.Artists;
import edu.kea.paintings.models.Artist;
import edu.kea.paintings.repositories.ArtistRepository;
import edu.kea.paintings.repositories.GalleryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = Artists.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class ArtistControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ArtistRepository artists;

    @MockBean
    private GalleryRepository galleries;

    @Test
    public void givenArtistsWhenGetArtistsThenReturnJsonArray() throws Exception {
        Artist artistOne = new Artist();
        Artist artistTwo = new Artist();
        Artist artistThree = new Artist();

        artistOne.setName("Salvador Dali");
        artistTwo.setName("Pablo Picasso");
        artistThree.setName("JanJanJan");

        List<Artist> allArtists = Arrays.asList(artistOne, artistTwo, artistThree);

        given(artists.findAll()).willReturn(allArtists);

        mvc.perform(get("/artists")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("Salvador Dali")))
                .andExpect(jsonPath("$[1].name", is("Pablo Picasso")))
                .andExpect(jsonPath("$[2].name", is("JanJanJan")));

        verify(artists, VerificationModeFactory.times(1)).findAll();
        reset(artists);

    }
}
