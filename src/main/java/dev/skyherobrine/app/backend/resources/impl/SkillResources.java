package dev.skyherobrine.app.backend.resources.impl;

import dev.skyherobrine.app.backend.exceptions.EntityIdNotFoundException;
import dev.skyherobrine.app.backend.models.Response;
import dev.skyherobrine.app.backend.models.Skill;
import dev.skyherobrine.app.backend.resources.IManagement;
import dev.skyherobrine.app.backend.services.impl.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/skill")
@Slf4j
public class SkillResources implements IManagement<Skill,Long> {

    @Autowired
    private SkillService ss;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Skill skill) {
        log.info("Calling insert skill");
        try {
            Skill output = ss.add(skill);
            log.info("Insert skill successfully");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert skill successfully",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert skill failed");
            log.error("Error: ", e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert skill failed!",
                    null
            ));
        }
    }

    @Override
    public ResponseEntity<Response> insertAll(List<Skill> list) {
        return null;
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong, @RequestBody Skill skill) {
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
        log.info("Calling get skill by id = " + aLong);
        try {
            Optional<Skill> opCan = ss.getById(aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Get skill successfully",
                    opCan.get()
            ));
        } catch (EntityIdNotFoundException e) {
            log.warn("Get skill failed for the skill id not found!");
            return ResponseEntity.ok(new Response(
                    HttpStatus.NO_CONTENT.value(),
                    "The skill id = " + aLong + " was not found!",
                    null
            ));
        } catch (Exception e) {
            log.error("Get skill failed");
            log.error("Error: ", e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Get skill failed!",
                    null
            ));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all skill successfully",
                ss.getAll()
        ));
    }
}
