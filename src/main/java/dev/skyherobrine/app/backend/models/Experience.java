package dev.skyherobrine.app.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Experience {
    @Id @Column(name = "exp_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long expId;
    @Column(name = "company", length = 120, nullable = false)
    private String companyName;
    @Column(name = "work_desc", length = 400)
    private String workDescription;
    @Column(nullable = false, length = 100)
    private String role;
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;
    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;
    @ManyToOne @JoinColumn(name = "can_id", nullable = false)
    private Candidate candidate;
}
