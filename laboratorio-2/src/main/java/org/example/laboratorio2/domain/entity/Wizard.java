package org.example.laboratorio2.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "wizard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "house")
    private String house;

    @Column(name = "patronus")
    private String patronus;

    @Column(name = "deatheter")
    private Boolean isDeatheter;
}
