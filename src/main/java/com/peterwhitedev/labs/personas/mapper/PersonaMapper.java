package com.peterwhitedev.labs.personas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import com.capgemini.curso1_spring1.api.domain.Persona;
import com.capgemini.curso1_spring1.api.domain.PersonaInput;
import com.peterwhitedev.labs.personas.entity.PersonaEntity;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

	Persona toDto(PersonaEntity personaEntity);

	PersonaEntity toEntity(PersonaInput input);
	
	void updateEntityFromRequest(PersonaInput personaInput, @MappingTarget PersonaEntity personaEntity);

}