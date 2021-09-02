package com.example.mesttra.secretariat.model;

import com.example.mesttra.secretariat.enums.Folder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Secretariat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Folder folder;

    private String secretary;

    private Integer populationGrade;

    private Boolean underInvestigation;
}
