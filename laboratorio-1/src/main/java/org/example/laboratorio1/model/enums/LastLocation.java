package org.example.laboratorio1.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LastLocation {
    LAB("Laboratorio"),
    COMMISSARY("Comisaría"),
    MANSION("Mansión"),
    VILLAGE("Pueblo");

    private final String name;
}
