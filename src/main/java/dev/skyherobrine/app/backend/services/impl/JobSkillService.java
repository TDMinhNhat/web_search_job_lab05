package dev.skyherobrine.app.backend.services.impl;

import dev.skyherobrine.app.backend.exceptions.EntityIdNotFoundException;
import dev.skyherobrine.app.backend.ids.JobSkillId;
import dev.skyherobrine.app.backend.models.Job;
import dev.skyherobrine.app.backend.models.JobSkill;
import dev.skyherobrine.app.backend.repositories.JobSkillRepository;
import dev.skyherobrine.app.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobSkillService implements IServices<JobSkill, JobSkillId> {

    @Autowired
    private JobSkillRepository jsr;

    @Override
    public JobSkill add(JobSkill jobSkill) {
        return jsr.save(jobSkill);
    }

    @Override
    public List<JobSkill> addMany(List<JobSkill> list) {
        List<JobSkill> results = new ArrayList<>();
        Iterator<JobSkill> output = jsr.saveAll(list).iterator();
        output.forEachRemaining(results::add);
        return results;
    }

    @Override
    public JobSkill update(JobSkill jobSkill) {
        return jsr.save(jobSkill);
    }

    @Override
    public void delete(JobSkillId jobSkillId) throws EntityIdNotFoundException {
        jsr.delete(getById(jobSkillId).orElseThrow(() -> new EntityIdNotFoundException("JobId: " + jobSkillId.getJob().getId() + " SkillId: " + jobSkillId.getSkill().getId())));
    }

    @Override
    public Optional<JobSkill> getById(JobSkillId jobSkillId) throws EntityIdNotFoundException {
        return Optional.of(jsr.findById(jobSkillId).orElseThrow(() -> new EntityIdNotFoundException("JobId: " + jobSkillId.getJob().getId() + " SkillId: " + jobSkillId.getSkill().getId())));
    }

    @Override
    public Iterator<JobSkill> getAll() {
        return jsr.findAll().iterator();
    }

    public List<JobSkill> getAllJobsBySkill(Long skillId) {
        return jsr.findById_Skill_Id(skillId);
    }
}
