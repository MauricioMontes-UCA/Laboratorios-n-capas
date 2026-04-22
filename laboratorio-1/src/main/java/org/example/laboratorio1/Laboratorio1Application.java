package org.example.laboratorio1;

import org.example.laboratorio1.services.SpecimenService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Laboratorio1Application {

    public static void main(String[] args) {
        SpringApplication.run(Laboratorio1Application.class, args);
    }

    @Bean
    public CommandLineRunner run(SpecimenService specimenService) {
        return args -> {
            String tag = "[S.T.A.R.S-Report] ";

            specimenService.findAll().forEach(specimen ->
                System.out.println(
                        tag + "Nombre: " + specimen.getName() + " | "
                            + "Nivel de Peligro: " + specimen.getDangerLevel().getLevel() + " | "
                            + "Punto débil: " + specimen.getWeakSpot()
                ));
        };
    }

}
