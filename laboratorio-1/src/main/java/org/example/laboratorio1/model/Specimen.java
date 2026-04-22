package org.example.laboratorio1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Specimen {
    private String name;
    private String baseVirus;
    private int dangerLevel;
    private String weakSpot;
    private String status;
    private String lastLocation;
    private String nextPossibleOutbreak;
}
