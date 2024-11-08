package dev.skyherobrine.app.backend.models;

import dev.skyherobrine.app.backend.enums.SkillLevel;
import dev.skyherobrine.app.backend.ids.JobSkillId;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "job_skill", schema = "works")
@NoArgsConstructor
@RequiredArgsConstructor
public class JobSkill {
    @EmbeddedId @NonNull
    private JobSkillId id;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "skill_level", nullable = false) @NonNull
    private SkillLevel skillLevel;
}