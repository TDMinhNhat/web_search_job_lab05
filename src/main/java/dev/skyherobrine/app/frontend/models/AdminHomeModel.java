package dev.skyherobrine.app.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.skyherobrine.app.backend.models.Candidate;
import dev.skyherobrine.app.backend.models.Response;
import dev.skyherobrine.app.backend.models.Skill;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class AdminHomeModel {

    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private RestTemplate rt = new RestTemplate();
    private final String uri = "http://localhost:8080/api/v1/";

    public List<Skill> getAllSkills() {
        List<Skill> results = null;

        Response response = rt.getForObject(URI.create(uri + "skill"), Response.class);
        results = mapper.convertValue(response.getData(), new TypeReference<List<Skill>>() {});

        return results;
    }

    public List<Candidate> getAllCandidates() {
        List<Candidate> results = null;

        Response response = rt.getForObject(URI.create(uri + "candidate"), Response.class);
        results = mapper.convertValue(response.getData(), new TypeReference<>() {});

        return results;
    }

}
