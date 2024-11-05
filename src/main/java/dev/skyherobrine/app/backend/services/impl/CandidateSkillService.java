package dev.skyherobrine.app.backend.services.impl;

import dev.skyherobrine.app.backend.exceptions.EntityIdNotFoundException;
import dev.skyherobrine.app.backend.ids.CandidateSkillId;
import dev.skyherobrine.app.backend.models.Candidate;
import dev.skyherobrine.app.backend.models.CandidateSkill;
import dev.skyherobrine.app.backend.repositories.CandidateSkillRepository;
import dev.skyherobrine.app.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateSkillService implements IServices<CandidateSkill, CandidateSkillId> {

    @Autowired
    private CandidateSkillRepository csr;

    @Override
    public CandidateSkill add(CandidateSkill candidateSkill) {
        return csr.save(candidateSkill);
    }

    @Override
    public List<CandidateSkill> addMany(List<CandidateSkill> list) {
        List<CandidateSkill> results = new ArrayList<>();
        Iterator<CandidateSkill> output = csr.saveAll(list).iterator();
        output.forEachRemaining(results::add);
        return results;
    }

    @Override
    public CandidateSkill update(CandidateSkill candidateSkill) {
        return csr.save(candidateSkill);
    }

    @Override
    public void delete(CandidateSkillId id) throws EntityIdNotFoundException {
        csr.delete(getById(id).orElseThrow(() -> new EntityIdNotFoundException("skillId: " + id.getCandidate() + ", candidateId: " + id.getCandidate())));
    }

    @Override
    public Optional<CandidateSkill> getById(CandidateSkillId id) throws EntityIdNotFoundException {
        return Optional.of(csr.findById(id).orElseThrow(() -> new EntityIdNotFoundException("skillId: " + id.getSkill() + ", candidateId: " + id.getSkill())));
    }

    @Override
    public Iterator<CandidateSkill> getAll() {
        return csr.findAll().iterator();
    }
}
