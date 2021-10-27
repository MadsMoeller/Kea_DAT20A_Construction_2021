package edu.kea.paintings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name="galleries")
@Entity
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String owner;

    @Column
    private String location;

    @Column
    private int squareMeters;

    @JsonIgnore
    @OneToMany(mappedBy = "gallery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Artist> artists;

}
