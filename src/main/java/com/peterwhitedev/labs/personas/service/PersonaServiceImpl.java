package com.peterwhitedev.labs.personas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.curso1_spring1.api.domain.Persona;
import com.capgemini.curso1_spring1.api.domain.PersonaInput;
import com.peterwhitedev.labs.personas.entity.PersonaEntity;
import com.peterwhitedev.labs.personas.mapper.PersonaMapper;
import com.peterwhitedev.labs.personas.repository.PersonaJpaRepository;
import com.peterwhitedev.labs.personas.web.error.PersonaNotFoundException;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaJpaRepository personaJpaRepository;
    private final PersonaMapper personaMapper;
    
   
    public PersonaServiceImpl(PersonaJpaRepository personaJpaRepository, PersonaMapper personaMapper) {
        this.personaJpaRepository = personaJpaRepository;
        this.personaMapper = personaMapper;
    }

    @Override
    public Persona getPersonaById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El id debe ser un número positivo");
        }
        return personaJpaRepository.findById(id).map(personaMapper::toDto)
        		.orElseThrow(() -> new PersonaNotFoundException("Persona no encontrada con id: " + id));       
    }

    @Override
    public List<Persona> getAllPersonas() {
    	return personaJpaRepository.findAll().stream().map(personaMapper::toDto).toList();
       
    }

	@Override
	public Persona crearPersona(PersonaInput personaInput) {
		if (personaInput == null) {
            throw new IllegalArgumentException("Datos de persona no válidos");
        }
        PersonaEntity entity = personaMapper.toEntity(personaInput);
        PersonaEntity guardada = personaJpaRepository.save(entity);
        return personaMapper.toDto(guardada);
      
	}

	@Override
	public Persona actualizarPersona(Integer id, PersonaInput personaInput) {
		PersonaEntity entity = personaJpaRepository.findById(id)
            .orElseThrow(() -> new PersonaNotFoundException("Persona no encontrada con id: " + id));
        
		personaMapper.updateEntityFromRequest(personaInput, entity);		
		// Actualizar la entidad en la base de datos, los campos nombre / edad
		PersonaEntity actualizada = personaJpaRepository.save(entity);
		return personaMapper.toDto(actualizada);
		
	}

	@Override
	public Persona eliminarPersona(Integer id) {
		PersonaEntity entity = personaJpaRepository.findById(id)
            .orElseThrow(() -> new PersonaNotFoundException("Persona no encontrada con id: " + id));
        personaJpaRepository.deleteById(id);
        return personaMapper.toDto(entity);
	}
	
	@Override
	public Boolean personasEliminarTodas() {
        personaJpaRepository.deleteAll(); 
        return true;
	}
}