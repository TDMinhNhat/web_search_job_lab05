package dev.skyherobrine.app.backend.ids;

import dev.skyherobrine.app.backend.models.Job;
import dev.skyherobrine.app.backend.models.Skill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class JobSkillId implements Serializable {
    private static final long serialVersionUID = 2323802082645217969L;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

}