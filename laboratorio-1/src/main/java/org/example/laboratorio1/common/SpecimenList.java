package org.example.laboratorio1.common;

import org.example.laboratorio1.model.Specimen;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecimenList {
    private final List<Specimen> specimens;

    public SpecimenList() {
        this.specimens = List.of(

        );
    }
}
