package org.example.laboratorio1.model.enums;

import lombok.Getter;

@Getter
public enum DangerLevel {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int level;

    DangerLevel(int level) {
        this.level = level;
    }

    // Honestamente, no sé trabajar con Enums, solo sabía que era para normalizar
    // Así que estos cambios de acá fueron hechos con IA para poder imprimir los números.
}
