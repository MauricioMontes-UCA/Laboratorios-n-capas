package org.example.laboratorio3.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.laboratorio3.common.mappers.SpecimenMapper;
import org.example.laboratorio3.domain.dto.requests.CreateSpecimenRequest;
import org.example.laboratorio3.domain.dto.requests.UpdateSpecimenRequest;
import org.example.laboratorio3.domain.dto.response.PageableResponse;
import org.example.laboratorio3.domain.dto.response.specimen.SpecimenResponse;
import org.example.laboratorio3.domain.entities.Specimen;
import org.example.laboratorio3.exceptions.ResourceNotFoundException;
import org.example.laboratorio3.repositories.SpecimenRepository;
import org.example.laboratorio3.services.SpecimenService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public PageableResponse<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<SpecimenResponse> specimenResponsePage = SpecimenMapper.toDTOList(specimenRepository.findAll(pageable));

        if (specimenResponsePage.getTotalElements() == 0)
            throw new ResourceNotFoundException("No products are registered");

        return PageableResponse.<SpecimenResponse>builder()
                .content(specimenResponsePage.getContent())
                .page(specimenResponsePage.getNumber())
                .size(specimenResponsePage.getSize())
                .totalElements(specimenResponsePage.getTotalElements())
                .last(specimenResponsePage.isLast())
                .build();
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
