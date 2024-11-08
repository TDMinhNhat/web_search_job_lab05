package dev.skyherobrine.app.backend.repositories;

import dev.skyherobrine.app.backend.ids.CandidateSkillId;
import dev.skyherobrine.app.backend.models.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
    List<CandidateSkill> findById_Candidate_Id(Long id);

}