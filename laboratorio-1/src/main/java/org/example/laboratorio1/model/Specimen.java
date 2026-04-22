package org.example.laboratorio1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.laboratorio1.model.enums.BaseVirus;
import org.example.laboratorio1.model.enums.DangerLevel;
import org.example.laboratorio1.model.enums.LastLocation;
import org.example.laboratorio1.model.enums.Status;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Specimen {
    private String name;
    private BaseVirus baseVirus;
    private DangerLevel dangerLevel;
    private String weakSpot;
    private Status status;
    private LastLocation lastLocation;
    private String nextPossibleOutbreak;
}
