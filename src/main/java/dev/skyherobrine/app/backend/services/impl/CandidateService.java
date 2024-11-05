package dev.skyherobrine.app.backend.services.impl;

import dev.skyherobrine.app.backend.exceptions.EntityIdNotFoundException;
import dev.skyherobrine.app.backend.models.Candidate;
import dev.skyherobrine.app.backend.repositories.CandidateRepository;
import dev.skyherobrine.app.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements IServices<Candidate,Long> {

    @Autowired
    private CandidateRepository cr;

    @Override
    public Candidate add(Candidate candidate) {
        return cr.save(candidate);
    }

    @Override
    public List<Candidate> addMany(List<Candidate> list) {
        List<Candidate> results = new ArrayList<>();
        Iterator<Candidate> output = cr.saveAll(list).iterator();
        output.forEachRemaining(results::add);
        return results;
    }

    @Override
    public Candidate update(Candidate candidate) {
        return cr.save(candidate);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException {
        cr.delete(cr.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Optional<Candidate> getById(Long aLong) throws EntityIdNotFoundException {
        return Optional.of(cr.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Iterator<Candidate> getAll() {
        return cr.findAll().iterator();
    }

    public Iterator<Candidate> getAll(Pageable pageable) {
        return cr.findAll(pageable).iterator();
    }

    public Candidate checkLoginAccount(String email, String password) {
        return cr.findByEmailAndPassword(email, password).orElse(null);
    }
}
