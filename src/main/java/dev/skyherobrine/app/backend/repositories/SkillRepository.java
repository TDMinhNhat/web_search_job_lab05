package dev.skyherobrine.app.backend.repositories;

import dev.skyherobrine.app.backend.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {
}