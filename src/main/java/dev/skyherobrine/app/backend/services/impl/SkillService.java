package dev.skyherobrine.app.backend.services.impl;

import dev.skyherobrine.app.backend.exceptions.EntityIdNotFoundException;
import dev.skyherobrine.app.backend.models.JobSkill;
import dev.skyherobrine.app.backend.models.Skill;
import dev.skyherobrine.app.backend.repositories.SkillRepository;
import dev.skyherobrine.app.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class SkillService implements IServices<Skill,Long> {

    @Autowired
    private SkillRepository sr;

    @Override
    public Skill add(Skill skill) {
        return sr.save(skill);
    }

    @Override
    public List<Skill> addMany(List<Skill> list) {
        List<Skill> results = new ArrayList<>();
        Iterator<Skill> output = sr.saveAll(list).iterator();
        output.forEachRemaining(results::add);
        return results;
    }

    @Override
    public Skill update(Skill skill) {
        return sr.save(skill);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException {
        sr.delete(sr.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Optional<Skill> getById(Long aLong) throws EntityIdNotFoundException {
        return Optional.of(sr.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Iterator<Skill> getAll() {
        return sr.findAll().iterator();
    }
}
