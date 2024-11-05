package dev.skyherobrine.app.backend.ids;

import dev.skyherobrine.app.backend.models.Candidate;
import dev.skyherobrine.app.backend.models.Skill;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSkillId implements Serializable {
    private static final long serialVersionUID = 7959505589146447260L;
    @ManyToOne
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;
}