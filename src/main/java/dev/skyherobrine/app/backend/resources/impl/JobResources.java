package dev.skyherobrine.app.backend.resources.impl;

import dev.skyherobrine.app.backend.models.Job;
import dev.skyherobrine.app.backend.models.Response;
import dev.skyherobrine.app.backend.resources.IManagement;
import dev.skyherobrine.app.backend.services.impl.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jobs")
@Slf4j
public class JobResources implements IManagement<Job,Long> {

    @Autowired
    private JobService js;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Job job) {
        return null;
    }

    @Override
    public ResponseEntity<Response> insertAll(@RequestBody List<Job> list) {
        return null;
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong, @RequestBody Job job) {
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
        return null;
    }
}
