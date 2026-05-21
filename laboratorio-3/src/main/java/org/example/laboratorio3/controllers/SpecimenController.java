package org.example.laboratorio3.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.laboratorio3.domain.dto.requests.CreateSpecimenRequest;
import org.example.laboratorio3.domain.dto.requests.UpdateSpecimenRequest;
import org.example.laboratorio3.domain.dto.response.GeneralResponse;
import org.example.laboratorio3.services.impl.SpecimenServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("api/records")
@RequiredArgsConstructor
public class SpecimenController {
    private final SpecimenServiceImpl specimenService;

    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity
                .status(status)
                .body(GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
                );
    }

    @PostMapping("/specimen")
    public ResponseEntity<GeneralResponse> createSpecimen(@RequestBody @Valid CreateSpecimenRequest request) {
        return buildResponse(
                "Specimen was successfully added to the Records.",
                HttpStatus.CREATED,
                specimenService.createSpecimen(request)
        );
    }

    @GetMapping("/specimen")
    public ResponseEntity<GeneralResponse> getAllSpecimens(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        return buildResponse(
                "Specimens found",
                HttpStatus.OK,
                specimenService.getAllSpecimens(page, size, sortBy, sortOrder)
        );
    }

    @GetMapping("/specimen/{id}")
    public ResponseEntity<GeneralResponse> getSpecimenById(@PathVariable UUID id) {
        return buildResponse(
                "Specimen found",
                HttpStatus.FOUND,
                specimenService.getSpecimenById(id)
        );
    }

    @PutMapping("/specimen/{id}")
    public ResponseEntity<GeneralResponse> updateSpecimen(
            @PathVariable UUID id,
            @RequestBody UpdateSpecimenRequest request
    ) {
        return buildResponse(
                "Specimen updated successfully",
                HttpStatus.OK,
                specimenService.updateSpecimen(id, request)
        );
    }

    @DeleteMapping("/specimen/{id}")
    public ResponseEntity<GeneralResponse> deleteSpecimenById(@PathVariable UUID id) {
        return buildResponse(
                "Specimen deleted successfully from the Records",
                HttpStatus.OK,
                specimenService.deleteSpecimen(id)
        );
    }
}
