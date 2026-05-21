package org.example.laboratorio3.services.impl;

import org.example.laboratorio3.domain.dto.requests.CreateSpecimenRequest;
import org.example.laboratorio3.domain.dto.requests.UpdateSpecimenRequest;
import org.example.laboratorio3.domain.dto.response.SpecimenResponse;
import org.example.laboratorio3.repositories.SpecimenRepository;
import org.example.laboratorio3.services.SpecimenService;

import java.util.List;
import java.util.UUID;

public class SpecimenServiceImpl implements SpecimenService {
    private final SpecimenRepository specimenRepository;

    @Override
    public SpecimenResponse createSpecimen(CreateSpecimenRequest request) {
        return null;
    }

    @Override
    public List<SpecimenResponse> getAllSpecimens() {
        return List.of();
    }

    @Override
    public SpecimenResponse getSpecimenById(UUID id) {
        return null;
    }

    @Override
    public SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request) {
        return null;
    }

    @Override
    public SpecimenResponse deleteSpecimen(UUID id) {
        return null;
    }
}
