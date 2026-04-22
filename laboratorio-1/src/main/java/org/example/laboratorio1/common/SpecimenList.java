package org.example.laboratorio1.common;

import lombok.Getter;
import org.example.laboratorio1.model.Specimen;
import org.example.laboratorio1.model.enums.BaseVirus;
import org.example.laboratorio1.model.enums.DangerLevel;
import org.example.laboratorio1.model.enums.LastLocation;
import org.example.laboratorio1.model.enums.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Component
public class SpecimenList {
    private final List<Specimen> specimens;

    public SpecimenList() {
        this.specimens = List.of(

                Specimen.builder()
                        .name("Zombie")
                        .baseVirus(BaseVirus.T_VIRUS)
                        .dangerLevel(DangerLevel.ONE)
                        .weakSpot("Cabeza")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.COMMISSARY)
                        .nextPossibleOutbreak("Raccoon City")
                        .build(),

                Specimen.builder()
                        .name("Licker")
                        .baseVirus(BaseVirus.T_VIRUS)
                        .dangerLevel(DangerLevel.THREE)
                        .weakSpot("Cerebro expuesto")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.COMMISSARY)
                        .nextPossibleOutbreak("Raccoon City Underground")
                        .build(),

                Specimen.builder()
                        .name("Tyrant T-002")
                        .baseVirus(BaseVirus.T_VIRUS)
                        .dangerLevel(DangerLevel.FIVE)
                        .weakSpot("Corazón expuesto")
                        .status(Status.CONTAINED)
                        .lastLocation(LastLocation.LAB)
                        .nextPossibleOutbreak("Arklay Mountains")
                        .build(),

                Specimen.builder()
                        .name("Hunter Alpha")
                        .baseVirus(BaseVirus.T_VIRUS)
                        .dangerLevel(DangerLevel.THREE)
                        .weakSpot("Cabeza")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.MANSION)
                        .nextPossibleOutbreak("Raccoon Forest")
                        .build(),

                Specimen.builder()
                        .name("Chimera")
                        .baseVirus(BaseVirus.T_VIRUS)
                        .dangerLevel(DangerLevel.TWO)
                        .weakSpot("Abdomen")
                        .status(Status.CONTAINED)
                        .lastLocation(LastLocation.LAB)
                        .nextPossibleOutbreak("Arklay Laboratory")
                        .build(),

                Specimen.builder()
                        .name("G-Mutant Stage 1")
                        .baseVirus(BaseVirus.G_VIRUS)
                        .dangerLevel(DangerLevel.FOUR)
                        .weakSpot("Ojo derecho")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.COMMISSARY)
                        .nextPossibleOutbreak("Raccoon City Sewers")
                        .build(),

                Specimen.builder()
                        .name("G-Mutant Stage 4")
                        .baseVirus(BaseVirus.G_VIRUS)
                        .dangerLevel(DangerLevel.FIVE)
                        .weakSpot("Núcleo central")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.LAB)
                        .nextPossibleOutbreak("NEST Laboratory")
                        .build(),

                Specimen.builder()
                        .name("Birkin Embrión")
                        .baseVirus(BaseVirus.G_VIRUS)
                        .dangerLevel(DangerLevel.THREE)
                        .weakSpot("Cuerpo del huésped")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.COMMISSARY)
                        .nextPossibleOutbreak("Raccoon City Orphanage")
                        .build(),

                Specimen.builder()
                        .name("Ganado")
                        .baseVirus(BaseVirus.LAS_PLAGAS)
                        .dangerLevel(DangerLevel.TWO)
                        .weakSpot("Parásito expuesto")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.VILLAGE)
                        .nextPossibleOutbreak("Rural Spain")
                        .build(),

                Specimen.builder()
                        .name("El Gigante")
                        .baseVirus(BaseVirus.LAS_PLAGAS)
                        .dangerLevel(DangerLevel.FOUR)
                        .weakSpot("Parásito en espalda")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.VILLAGE)
                        .nextPossibleOutbreak("Pueblo Exterior")
                        .build(),

                Specimen.builder()
                        .name("Verdugo")
                        .baseVirus(BaseVirus.LAS_PLAGAS)
                        .dangerLevel(DangerLevel.FIVE)
                        .weakSpot("Nitrógeno líquido + núcleo")
                        .status(Status.CONTAINED)
                        .lastLocation(LastLocation.LAB)
                        .nextPossibleOutbreak("Island Facility")
                        .build(),

                Specimen.builder()
                        .name("Novistador")
                        .baseVirus(BaseVirus.LAS_PLAGAS)
                        .dangerLevel(DangerLevel.THREE)
                        .weakSpot("Abdomen")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.MANSION)
                        .nextPossibleOutbreak("Salazar Castle")
                        .build(),

                Specimen.builder()
                        .name("Molded")
                        .baseVirus(BaseVirus.CADOU)
                        .dangerLevel(DangerLevel.TWO)
                        .weakSpot("Cabeza")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.MANSION)
                        .nextPossibleOutbreak("Louisiana Bayou")
                        .build(),

                Specimen.builder()
                        .name("Jack Baker Mutado")
                        .baseVirus(BaseVirus.CADOU)
                        .dangerLevel(DangerLevel.FOUR)
                        .weakSpot("Masa de tejido central")
                        .status(Status.ELIMINATED)
                        .lastLocation(LastLocation.MANSION)
                        .nextPossibleOutbreak("Baker Estate")
                        .build(),

                Specimen.builder()
                        .name("Lycan")
                        .baseVirus(BaseVirus.CADOU)
                        .dangerLevel(DangerLevel.THREE)
                        .weakSpot("Cabeza")
                        .status(Status.FREE)
                        .lastLocation(LastLocation.VILLAGE)
                        .nextPossibleOutbreak("Eastern Europe Village")
                        .build(),

                Specimen.builder()
                        .name("Moreau Mutado")
                        .baseVirus(BaseVirus.CADOU)
                        .dangerLevel(DangerLevel.FOUR)
                        .weakSpot("Tumor en la garganta")
                        .status(Status.ELIMINATED)
                        .lastLocation(LastLocation.VILLAGE)
                        .nextPossibleOutbreak("Reservoir Zone")
                        .build()
        );
    }
}