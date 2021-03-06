package br.com.mesttra.secretariat.model;

import br.com.mesttra.secretariat.enums.Folder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Secretariat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Folder folder;

    private String secretary;

    @Min(0)
    @Max(10)
    private Integer populationGrade;

    @Column(nullable = false)
    private Boolean underInvestigation;
}
