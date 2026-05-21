package org.example.laboratorio3.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.laboratorio3.common.mappers.SpecimenMapper;
import org.example.laboratorio3.domain.dto.requests.CreateSpecimenRequest;
import org.example.laboratorio3.domain.dto.requests.UpdateSpecimenRequest;
import org.example.laboratorio3.domain.dto.response.specimen.SpecimenResponse;
import org.example.laboratorio3.domain.entities.Specimen;
import org.example.laboratorio3.exceptions.ResourceNotFoundException;
import org.example.laboratorio3.repositories.SpecimenRepository;
import org.example.laboratorio3.services.SpecimenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpecimenServiceImpl implements SpecimenService {
    private final SpecimenRepository specimenRepository;

    @Override
    @Transactional
    public SpecimenResponse createSpecimen(CreateSpecimenRequest request) {
        return SpecimenMapper.toDTO(
                specimenRepository.save(SpecimenMapper.toEntityCreate(request))
        );
    }

    @Override
    public List<SpecimenResponse> getAllSpecimens() {
        List<Specimen> specimens = specimenRepository.findAll();
        if (specimens.isEmpty())
            throw new ResourceNotFoundException("No specimens are registered in Hyrule Records");
        return specimens.stream()
                .map(SpecimenMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SpecimenResponse getSpecimenById(UUID id) {
        return SpecimenMapper.toDTO(specimenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Specimen not found in Hyrule Records"))
        );
    }

    @Override
    @Transactional
    public SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request) {
        this.getSpecimenById(id);
        return SpecimenMapper.toDTO(
                specimenRepository.save(SpecimenMapper.toEntityUpdate(request, id))
        );
    }

    @Override
    @Transactional
    public SpecimenResponse deleteSpecimen(UUID id) {
        SpecimenResponse existSpecimen = this.getSpecimenById(id);
        specimenRepository.deleteById(id);
        return existSpecimen;
    }
}
