package dev.skyherobrine.app.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "address", schema = "works")
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street", length = 150)
    @NonNull
    private String street;

    @Column(name = "city", length = 50)
    @NonNull
    private String city;

    @Column(name = "country")
    @NonNull
    private Short country;

    @Column(name = "number", length = 20)
    @NonNull
    private String number;

    @Column(name = "zipcode", length = 7)
    @NonNull
    private String zipcode;

}