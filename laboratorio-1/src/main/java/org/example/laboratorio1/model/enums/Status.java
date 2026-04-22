package org.example.laboratorio1.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    CONTAINED("Contenido"),
    FREE("En libertad"),
    ELIMINATED("Eliminado");

    private final String name;
}
