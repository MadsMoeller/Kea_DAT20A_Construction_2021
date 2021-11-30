package mads.kea.prices_store.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="stores")
@Entity
public class Store {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String storeName;

    @Column
    private String owner;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Type type;

    @Enumerated(value = EnumType.STRING)
    @Column
    private CountryOfOrigin madeIn;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Price> prices;
}
