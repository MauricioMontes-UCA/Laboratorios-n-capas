package org.example.laboratorio2.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.laboratorio2.domain.entity.Wizard;
import org.example.laboratorio2.repository.WizardRepository;
import org.example.laboratorio2.service.WizardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WizardServiceImpl implements WizardService {
    private final WizardRepository wizardRepository;

    @Override
    public void createWizard(Wizard wizard) {
        wizardRepository.save(wizard);
    }

    @Override
    public List<Wizard> getAllWizards() {
        return wizardRepository.findAll();
    }

    @Override
    public List<Wizard> getAllDeatheaters() {
        return wizardRepository.getWizardsByIsDeatheater(true);
    }

    @Override
    public void updateWizard(UUID id, Wizard newWizard) {
        Wizard wizard = wizardRepository.getWizardById(id);
        wizard.setName(newWizard.getName());
        wizard.setHouse(newWizard.getHouse());
        wizard.setPatronus(newWizard.getPatronus());
        wizard.setIsDeatheater(newWizard.getIsDeatheater());
        wizardRepository.save(wizard);
    }

    @Override
    public List<Wizard> getWizardsByPatronus(String patronus) {
        return wizardRepository.getWizardsByPatronus(patronus);
    }

    @Override
    public Wizard deleteWizardById(UUID id) {
        Wizard deleted = wizardRepository.getWizardById(id);
        wizardRepository.deleteWizardById(id);
        return deleted;
    }
}
