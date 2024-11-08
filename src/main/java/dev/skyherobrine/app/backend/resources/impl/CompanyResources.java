package dev.skyherobrine.app.backend.resources.impl;

import dev.skyherobrine.app.backend.models.Company;
import dev.skyherobrine.app.backend.models.Response;
import dev.skyherobrine.app.backend.resources.IManagement;
import dev.skyherobrine.app.backend.services.impl.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/company")
@Slf4j
public class CompanyResources implements IManagement<Company,Long> {

    @Autowired
    private CompanyService cs;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Company company) {
        return null;
    }

    @Override
    public ResponseEntity<Response> insertAll(@RequestBody List<Company> list) {
        return null;
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong, @RequestBody Company company) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> getAll() {
        log.info("Calling get all companies");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all companies successfully",
                cs.getAll()
        ));
    }
}
