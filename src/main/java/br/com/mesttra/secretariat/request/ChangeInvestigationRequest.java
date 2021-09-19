package br.com.mesttra.secretariat.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeInvestigationRequest {

    @NonNull
    private Boolean underInvestigation;
}
