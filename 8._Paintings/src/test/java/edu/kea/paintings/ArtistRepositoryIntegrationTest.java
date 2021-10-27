package edu.kea.paintings;

import edu.kea.paintings.models.Artist;
import edu.kea.paintings.repositories.ArtistRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArtistRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ArtistRepository artists;

    @Test
    public void whenFindByName_thenReturnArtist(){
        //given
        Artist artist = new Artist();
        artist.setName("Salvador Dali");
        testEntityManager.persist(artist);
        testEntityManager.flush();

        //when
        Artist artistFound = artists.findByName("Salvador Dali");

        //then
        assertEquals(artistFound.getName(), artist.getName());
    }

}
