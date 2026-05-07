package org.example.laboratorio2.repository;

import org.example.laboratorio2.domain.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, UUID> {
    Wizard getWizardById(UUID id);

    List<Wizard> getWizardsByPatronus(String patronus);

    List<Wizard> getWizardsByIsDeatheater(Boolean isDeatheater);

    void deleteWizardById(UUID id);
}
