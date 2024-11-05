package dev.skyherobrine.app.backend.services.impl;

import dev.skyherobrine.app.backend.exceptions.EntityIdNotFoundException;
import dev.skyherobrine.app.backend.models.Company;
import dev.skyherobrine.app.backend.models.Experience;
import dev.skyherobrine.app.backend.repositories.ExperienceRepository;
import dev.skyherobrine.app.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService implements IServices<Experience,Long> {

    @Autowired
    private ExperienceRepository er;

    @Override
    public Experience add(Experience experience) {
        return er.save(experience);
    }

    @Override
    public List<Experience> addMany(List<Experience> list) {
        List<Experience> results = new ArrayList<>();
        Iterator<Experience> output = er.saveAll(list).iterator();
        output.forEachRemaining(results::add);
        return results;
    }

    @Override
    public Experience update(Experience experience) {
        return er.save(experience);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException {
        er.delete(er.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(String.valueOf(aLong))));
    }

    @Override
    public Optional<Experience> getById(Long aLong) throws EntityIdNotFoundException {
        return Optional.of(er.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(String.valueOf(aLong))));
    }

    @Override
    public Iterator<Experience> getAll() {
        return er.findAll().iterator();
    }
}
