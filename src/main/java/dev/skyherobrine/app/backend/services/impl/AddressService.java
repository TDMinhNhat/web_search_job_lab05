package dev.skyherobrine.app.backend.services.impl;

import dev.skyherobrine.app.backend.exceptions.EntityIdNotFoundException;
import dev.skyherobrine.app.backend.models.Address;
import dev.skyherobrine.app.backend.repositories.AddressRepository;
import dev.skyherobrine.app.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService implements IServices<Address,Long> {

    @Autowired
    private AddressRepository ar;

    @Override
    public Address add(Address address) {
        return ar.save(address);
    }

    @Override
    public List<Address> addMany(List<Address> list) {
        List<Address> results = new ArrayList<>();
        Iterator<Address> output = ar.saveAll(list).iterator();
        output.forEachRemaining(results::add);
        return results;
    }

    @Override
    public Address update(Address address) {
        return ar.save(address);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException {
        ar.delete(getById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Optional<Address> getById(Long aLong) throws EntityIdNotFoundException {
        return Optional.of(ar.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Iterator<Address> getAll() {
        return ar.findAll().iterator();
    }
}
