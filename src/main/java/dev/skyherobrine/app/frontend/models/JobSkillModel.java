package dev.skyherobrine.app.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.skyherobrine.app.backend.models.JobSkill;
import dev.skyherobrine.app.backend.models.Response;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class JobSkillModel {

    private final RestTemplate rt = new RestTemplate();
    private final String uri = "http://localhost:8080/api/v1/job-skill";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<JobSkill> getAllJobsBySkill(Long skillId) {
        Response response = rt.getForObject(URI.create(uri + "/jobs/" + skillId), Response.class);
        return mapper.convertValue(response.getData(), new TypeReference<List<JobSkill>>() {});
    }
}
