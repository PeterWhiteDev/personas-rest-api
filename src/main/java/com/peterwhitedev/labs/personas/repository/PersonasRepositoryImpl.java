package com.peterwhitedev.labs.personas.repository;

import com.peterwhitedev.labs.personas.api.domain.Persona;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonasRepositoryImpl implements PersonasRepository {

    @Override
    public Persona getPersonaById(Integer id) {
        if (id == 999) {
            return null;
        }
        Persona persona = new Persona();
        persona.setId(id);
        persona.setNombre("Persona " + id);
        persona.setEdad(30);
        return persona;
    }

    @Override
    public List<Persona> getAllPersonas() {
        List<Persona> personas = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Persona persona = new Persona();
            persona.setId(i);
            persona.setNombre("Persona " + i);
            persona.setEdad(20 + i);
            personas.add(persona);
        }
        return personas;
    }
}
