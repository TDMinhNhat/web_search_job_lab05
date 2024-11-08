package dev.skyherobrine.app.backend.resources.impl;

import dev.skyherobrine.app.backend.dto.CandidateAccountDTO;
import dev.skyherobrine.app.backend.exceptions.EntityIdNotFoundException;
import dev.skyherobrine.app.backend.models.Candidate;
import dev.skyherobrine.app.backend.models.CandidateSkill;
import dev.skyherobrine.app.backend.models.Response;
import dev.skyherobrine.app.backend.models.Skill;
import dev.skyherobrine.app.backend.resources.IManagement;
import dev.skyherobrine.app.backend.services.impl.CandidateService;
import dev.skyherobrine.app.backend.services.impl.CandidateSkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/candidate")
@Slf4j
public class CandidateResources implements IManagement<Candidate,Long> {

    @Autowired
    private CandidateService cs;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Candidate candidate) {
        log.info("Calling insert candidate");
        try {
           Candidate output = cs.add(candidate);
           log.info("Insert candidate successfully");
           return ResponseEntity.ok(new Response(
                   HttpStatus.OK.value(),
                   "Insert candidate successfully",
                   output
           ));
        } catch (Exception e) {
            log.error("Insert candidate failed");
            log.error("Error: ", e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert candidate failed!",
                    null
            ));
        }
    }

    @Override
    public ResponseEntity<Response> insertAll(List<Candidate> list) {
        return null;
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong, @RequestBody Candidate candidate) {
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
        log.info("Calling get candidate by id = " + aLong);
        try {
            Optional<Candidate> opCan = cs.getById(aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Get candidate successfully",
                    opCan.get()
            ));
        } catch (EntityIdNotFoundException e) {
            log.warn("Get candidate failed for the candidate id not found!");
            return ResponseEntity.ok(new Response(
                    HttpStatus.NO_CONTENT.value(),
                    "The candidate id = " + aLong + " was not found!",
                    null
            ));
        } catch (Exception e) {
            log.error("Get candidate failed");
            log.error("Error: ", e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Get candidate failed!",
                    null
            ));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all candidates successfully",
                cs.getAll()
        ));
    }

    @PostMapping("login")
    public ResponseEntity<Response> checkLoginAccount(@RequestBody CandidateAccountDTO caDto) {
        log.info("Calling check login account");
        String getEmail = caDto.getEmail();
        String getPassword = caDto.getPassword();

        try {
            Candidate output = cs.checkLoginAccount(getEmail, getPassword);
            if (output != null) {
                log.info("Check login account successfully");
                return ResponseEntity.ok(new Response(
                        HttpStatus.OK.value(),
                        "Check login account successfully",
                        output
                ));
            } else {
                log.warn("Check login account failed for the email or password is incorrect!");
                return ResponseEntity.ok(new Response(
                        HttpStatus.NO_CONTENT.value(),
                        "The email or password is incorrect!",
                        null
                ));
            }
        } catch (Exception e) {
            log.error("Check login account failed");
            log.error("Error: ", e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Check login account failed!",
                    null
            ));
        }
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<Response> getAll(@PathVariable("page") String pageNumber) {
        Pageable page = PageRequest.of(Integer.parseInt(pageNumber), 10);
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all candidates successfully",
                cs.getAll(page)
        ));
    }

    @GetMapping("/{id}/skills")
    public ResponseEntity<Response> getCandidateSkills(@PathVariable("id") Long canId) {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all candidate skills successfully",
                cs.getCandidateSkill(canId)
        ));
    }

    @GetMapping("/{id}/experiences")
    public ResponseEntity<Response> getCandidateExperience(@PathVariable("id") Long canId) {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all candidate experiences successfully",
                cs.getCandidateExperience(canId)
        ));
    }
}
