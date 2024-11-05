package dev.skyherobrine.app.backend.services.impl;

import dev.skyherobrine.app.backend.exceptions.EntityIdNotFoundException;
import dev.skyherobrine.app.backend.models.Experience;
import dev.skyherobrine.app.backend.models.Job;
import dev.skyherobrine.app.backend.repositories.JobRepository;
import dev.skyherobrine.app.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobService implements IServices<Job,Long> {

    @Autowired
    private JobRepository jr;

    @Override
    public Job add(Job job) {
        return jr.save(job);
    }

    @Override
    public List<Job> addMany(List<Job> list) {
        List<Job> results = new ArrayList<>();
        Iterator<Job> output = jr.saveAll(list).iterator();
        output.forEachRemaining(results::add);
        return results;
    }

    @Override
    public Job update(Job job) {
        return jr.save(job);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException {
        jr.delete(jr.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(String.valueOf(aLong))));
    }

    @Override
    public Optional<Job> getById(Long aLong) throws EntityIdNotFoundException {
        return Optional.of(jr.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(String.valueOf(aLong))));
    }

    @Override
    public Iterator<Job> getAll() {
        return jr.findAll().iterator();
    }
}
