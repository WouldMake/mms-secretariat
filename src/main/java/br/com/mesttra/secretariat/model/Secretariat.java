package br.com.mesttra.secretariat.model;

import br.com.mesttra.secretariat.enums.Folder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
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
