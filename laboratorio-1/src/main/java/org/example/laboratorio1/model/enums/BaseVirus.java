package org.example.laboratorio1.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BaseVirus {
    T_VIRUS("T-virus"),
    G_VIRUS("G-Virus"),
    LAS_PLAGAS("Las plagas"),
    CADOU("Cadou");

    private final String name;
}
