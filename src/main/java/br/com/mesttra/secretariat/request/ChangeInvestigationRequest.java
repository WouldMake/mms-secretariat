package br.com.mesttra.secretariat.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeInvestigationRequest {

    @NonNull
    private Boolean underInvestigation;
}
