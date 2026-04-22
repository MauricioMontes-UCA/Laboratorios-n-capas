package org.example.laboratorio1.services;

import lombok.RequiredArgsConstructor;
import org.example.laboratorio1.model.Specimen;
import org.example.laboratorio1.repository.SpecimenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecimenService {
    private final SpecimenRepository specimenRepository;

    public List<Specimen> findAll() {
        return specimenRepository.findAll();
    }
}
