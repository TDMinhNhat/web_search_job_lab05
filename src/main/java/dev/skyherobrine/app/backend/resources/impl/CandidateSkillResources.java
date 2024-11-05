package dev.skyherobrine.app.backend.resources.impl;

import dev.skyherobrine.app.backend.ids.CandidateSkillId;
import dev.skyherobrine.app.backend.models.CandidateSkill;
import dev.skyherobrine.app.backend.models.Response;
import dev.skyherobrine.app.backend.resources.IManagement;
import dev.skyherobrine.app.backend.services.impl.CandidateSkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidate-skill")
@Slf4j
public class CandidateSkillResources implements IManagement<CandidateSkill, CandidateSkillId> {

    @Autowired
    private CandidateSkillService css;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody CandidateSkill candidateSkill) {
        return null;
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Response> insertAll(@RequestBody List<CandidateSkill> list) {
        return null;
    }

    @PutMapping
    @Override
    public ResponseEntity<Response> update(CandidateSkillId candidateSkillId, CandidateSkill candidateSkill) {
        return null;
    }

    @DeleteMapping
    @Override
    public ResponseEntity<Response> delete(CandidateSkillId candidateSkillId) {
        return null;
    }

    @Override
    public ResponseEntity<Response> getById(CandidateSkillId candidateSkillId) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> getAll() {
        return null;
    }
}
