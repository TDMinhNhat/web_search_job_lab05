package dev.skyherobrine.app.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "company", schema = "works")
@NoArgsConstructor
@RequiredArgsConstructor
public class Company {
    @Id
    @Column(name = "comp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "about", length = 2000)
    private String about;

    @Column(name = "email", nullable = false) @NonNull
    private String email;

    @Column(name = "comp_name", nullable = false) @NonNull
    private String compName;

    @Column(name = "phone", nullable = false) @NonNull
    private String phone;

    @Column(name = "web_url")
    @NonNull
    private String webUrl;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address", nullable = false)
    @NonNull
    private Address address;

}