package edu.kea.paintings.repositories;

import edu.kea.paintings.models.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaintingRepository extends JpaRepository<Painting, Long> {

    List<Painting> findPaintingsByArtistAndYear(String artistName, int year);

    @Query(
            value = "SELECT * FROM paintings " +
                    "WHERE price > ?1",
            nativeQuery = true
    )
    List<Painting> findPaintingsMoreExpensiveThan(double price);


}
