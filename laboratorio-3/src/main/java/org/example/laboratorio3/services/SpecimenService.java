package org.example.laboratorio3.services;

import org.example.laboratorio3.domain.dto.requests.CreateSpecimenRequest;
import org.example.laboratorio3.domain.dto.requests.UpdateSpecimenRequest;
import org.example.laboratorio3.domain.dto.response.PageableResponse;
import org.example.laboratorio3.domain.dto.response.specimen.SpecimenResponse;

import java.util.List;
import java.util.UUID;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest request);
    PageableResponse<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder);
    SpecimenResponse getSpecimenById(UUID id);
    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);
    SpecimenResponse deleteSpecimen(UUID id);
}
