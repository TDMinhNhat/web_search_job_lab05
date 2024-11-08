package dev.skyherobrine.app.backend.resources.impl;

import dev.skyherobrine.app.backend.exceptions.EntityIdNotFoundException;
import dev.skyherobrine.app.backend.models.Address;
import dev.skyherobrine.app.backend.models.Response;
import dev.skyherobrine.app.backend.resources.IManagement;
import dev.skyherobrine.app.backend.services.impl.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/address")
@Slf4j
public class AddressResources implements IManagement<Address,Long> {

    @Autowired
    private AddressService as;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Address address) {
        log.info("Calling insert address");
        try {
            Address output = as.add(address);
            log.info("Insert address successfully");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert address successfully",
                    output
            ));
        } catch (Exception e) {
           log.error("Insert address failed");
           log.error("Error: ", e);
           return ResponseEntity.ok(new Response(
                     HttpStatus.OK.value(),
                     "Insert address failed!",
                     null
           ));
        }
    }

    @Override
    public ResponseEntity<Response> insertAll(List<Address> list) {
        return null;
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong, @RequestBody Address address) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(Long aLong) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) {
        log.info("Calling get address by id = " + aLong);
        try {
            Optional<Address> address = as.getById(aLong);
            log.info("Get address by id successfully");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Get address by id successfully",
                    address.get()
            ));
        } catch (EntityIdNotFoundException e) {
            log.warn("The address id = " + aLong + " not found");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "The address id = " + aLong + " not found",
                    null
            ));
        } catch (Exception e) {
            log.error("Get address by id failed");
            log.error("Error: ", e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Get address by id failed",
                    null
            ));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> getAll() {
        log.info("Calling get all addresses");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all address successfully",
                as.getAll()
        ));
    }
}
