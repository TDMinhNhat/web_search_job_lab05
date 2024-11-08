package dev.skyherobrine.app.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.skyherobrine.app.backend.models.Company;
import dev.skyherobrine.app.backend.models.Response;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class CompanyModel {

    private RestTemplate rt = new RestTemplate();
    private final String url = "http://localhost:8080/api/v1/company";
    private ObjectMapper mapper = new ObjectMapper();

    public List<Company> getAllCompanies() {
        Response response = rt.getForObject(URI.create(url), Response.class);
        return mapper.convertValue(response.getData(), new TypeReference<List<Company>>() {});
    }
}
