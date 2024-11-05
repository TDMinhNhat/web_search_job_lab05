package dev.skyherobrine.app.backend.repositories;

import dev.skyherobrine.app.backend.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}