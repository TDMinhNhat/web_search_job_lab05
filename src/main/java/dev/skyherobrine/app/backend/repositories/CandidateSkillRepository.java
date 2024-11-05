package dev.skyherobrine.app.backend.repositories;

import dev.skyherobrine.app.backend.ids.CandidateSkillId;
import dev.skyherobrine.app.backend.models.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
}