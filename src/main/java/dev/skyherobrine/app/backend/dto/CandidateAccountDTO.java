package dev.skyherobrine.app.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateAccountDTO {
    private String email;
    private String password;
}
