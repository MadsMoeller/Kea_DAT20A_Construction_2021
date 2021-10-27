package edu.kea.paintings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="paintings")
@Entity
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    @ApiModelProperty(notes = "Name of the artist")
    private String artist;

    @Column
    private double price;

    @Column
    private String title;

    @Column
    private String genre;

    @Column
    private int year;

    @JsonIgnore
    @Column
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "paintings_artists",
            joinColumns = {
                    @JoinColumn(name = "paintings_id", referencedColumnName = "id",
                            nullable = true, updatable = true)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "artists_id", referencedColumnName = "id",
                            nullable = true, updatable = true)
            }
    )
    private List<Artist> artists;

    public Painting(){}

    public Painting(String artist){
        this.artist = artist;
    }
}
