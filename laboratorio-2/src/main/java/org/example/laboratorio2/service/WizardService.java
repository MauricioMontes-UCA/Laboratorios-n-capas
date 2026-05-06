package org.example.laboratorio2.service;

import org.example.laboratorio2.domain.entity.Wizard;

import java.util.List;
import java.util.UUID;

public interface WizardService {
    void createWizard(Wizard wizard);
    List<Wizard> getAllWizards();
    List<Wizard> getAllDeatheaters();
    void updateWizard(UUID id, Wizard wizard);
    List<Wizard> getWizardsByPatronus(String patronus);
    Wizard deleteWizardById(UUID id);
}
