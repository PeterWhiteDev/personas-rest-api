package com.peterwhitedev.labs.personas.mapper;

import com.capgemini.curso1_spring1.api.domain.Persona;
import com.peterwhitedev.labs.personas.entity.PersonaEntity;

public class MapperPersona {

	public static PersonaEntity toEntity(Persona persona) {
		if (persona == null) {
			return null;
		}
		PersonaEntity entity = new PersonaEntity();
		entity.setId(persona.getId());
		entity.setNombre(persona.getNombre());
		entity.setEdad(persona.getEdad());
		return entity;
	}
	
	public static Persona toDto(PersonaEntity entity) {
		if (entity == null) {
			return null;
		}
		Persona persona = new Persona();
		persona.setId(entity.getId().intValue());
		persona.setNombre(entity.getNombre());
		persona.setEdad(entity.getEdad());
		return persona;
	}
}
