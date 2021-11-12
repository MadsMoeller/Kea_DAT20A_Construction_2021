package edu.kea.paintings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="artists")
@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String image;

    @Column
    private String primaryStyle;

    @Column(length = 100)
    private String nationality;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Gender gender;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    @JsonIgnore
    @ManyToMany(mappedBy = "artists", fetch = FetchType.LAZY)
    private List<Painting> paintings;
}
