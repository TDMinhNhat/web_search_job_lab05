package dev.skyherobrine.app.backend.repositories;

import dev.skyherobrine.app.backend.ids.JobSkillId;
import dev.skyherobrine.app.backend.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
    List<JobSkill> findById_Skill_Id(Long id);

}