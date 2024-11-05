package dev.skyherobrine.app.backend.models;

import dev.skyherobrine.app.backend.enums.SkillLevel;
import dev.skyherobrine.app.backend.ids.CandidateSkillId;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "candidate_skill", schema = "works")
@RequiredArgsConstructor
@NoArgsConstructor
public class CandidateSkill {
    @EmbeddedId @NonNull
    private CandidateSkillId id;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "skill_level", nullable = false)
    @NonNull
    private SkillLevel skillLevel;
}