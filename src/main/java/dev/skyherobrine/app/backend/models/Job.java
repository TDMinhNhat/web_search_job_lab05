package dev.skyherobrine.app.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "job", schema = "works")
@NoArgsConstructor
@RequiredArgsConstructor
public class Job {
    @Id
    @Column(name = "job_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "job_desc", nullable = false, length = 2000)
    private String jobDesc;

    @Column(name = "job_name", nullable = false) @NonNull
    private String jobName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company")
    @NonNull
    private Company company;

}