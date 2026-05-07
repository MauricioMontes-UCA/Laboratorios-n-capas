package org.example.laboratorio2.controller;

import lombok.AllArgsConstructor;
import org.example.laboratorio2.domain.entity.Wizard;
import org.example.laboratorio2.service.impl.WizardServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/wizards")
@AllArgsConstructor
public class WizardController {
    private final WizardServiceImpl wizardService;

    @PostMapping("/")
    public ResponseEntity<Wizard> addWizard(@RequestBody Wizard wizard) {
        wizardService.createWizard(wizard);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(wizard);
    }

    @GetMapping("/")
    public ResponseEntity<List<Wizard>> getWizards() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wizardService.getAllWizards());
    }

    @GetMapping("/deatheaters")
    public ResponseEntity<List<Wizard>> getDeatheaters() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wizardService.getAllDeatheaters());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wizard> updateWizard(
            @PathVariable UUID id,
            @RequestBody Wizard updated
    ) {
        wizardService.updateWizard(id, updated);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updated);
    }

    @GetMapping("/patronus/{patronus}")
    public ResponseEntity<List<Wizard>> getWizardsByPatronus(@PathVariable String patronus) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wizardService.getWizardsByPatronus(patronus));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Wizard> deleteWizard(@PathVariable UUID id) {
        Wizard deleted = wizardService.deleteWizardById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deleted);
    }
}