package org.example.laboratorio1.repository;

import lombok.RequiredArgsConstructor;
import org.example.laboratorio1.common.SpecimenList;
import org.example.laboratorio1.model.Specimen;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SpecimenRepository {
    // Acceso a la capa de datos, que en este caso es una lista
    private final SpecimenList specimenList;

    // Función para mostrar los datos a la siguiente capa
    public List<Specimen> findAll() {
        return specimenList.getSpecimens();
    }
}
