package dev.skyherobrine.app.backend.resources.impl;

import dev.skyherobrine.app.backend.ids.JobSkillId;
import dev.skyherobrine.app.backend.models.JobSkill;
import dev.skyherobrine.app.backend.models.Response;
import dev.skyherobrine.app.backend.resources.IManagement;
import dev.skyherobrine.app.backend.services.impl.JobSkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/job-skill")
@Slf4j
public class JobSkillResources implements IManagement<JobSkill, JobSkillId> {

    @Autowired
    private JobSkillService jss;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody JobSkill jobSkill) {
        return null;
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Response> insertAll(@RequestBody List<JobSkill> list) {
        return null;
    }

    @PutMapping
    @Override
    public ResponseEntity<Response> update(JobSkillId jobSkillId, JobSkill jobSkill) {
        return null;
    }

    @DeleteMapping
    @Override
    public ResponseEntity<Response> delete(JobSkillId jobSkillId) {
        return null;
    }

    @Override
    public ResponseEntity<Response> getById(JobSkillId jobSkillId) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> getAll() {
        return null;
    }
}
