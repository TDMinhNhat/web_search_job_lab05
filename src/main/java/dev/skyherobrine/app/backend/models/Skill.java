package dev.skyherobrine.app.backend.models;

import dev.skyherobrine.app.backend.enums.SkillType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "skill", schema = "works")
@RequiredArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id
    @Column(name = "skill_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill_description")
    private String skillDescription;

    @Column(name = "skill_name") @NonNull
    private String skillName;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type")
    @NonNull
    private SkillType type;

    public Skill(String skillDescription, @NonNull String skillName, @NonNull SkillType type) {
        this.skillDescription = skillDescription;
        this.skillName = skillName;
        this.type = type;
    }
}