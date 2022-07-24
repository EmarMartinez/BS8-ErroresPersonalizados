package com.bosonit.BD1crud.infraestructure.controller;

import com.bosonit.BD1crud.application.PersonaService;
import com.bosonit.BD1crud.exceptions.UnprocesableException;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorPost {

    @Autowired
    PersonaService personaservice;

    @PostMapping("/persona")
    public PersonaOutputDto crearPersona(@RequestBody PersonaInputDto personaInputDto){
        try {
            return personaservice.addPersona(personaInputDto);
        }
        catch(UnprocesableException e) {
            throw new UnprocesableException(e.getMessage());
        }
    }
}
