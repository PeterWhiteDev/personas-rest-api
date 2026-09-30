package com.peterwhitedev.labs.personas.service;

import com.capgemini.curso1_spring1.api.domain.Persona;
import com.capgemini.curso1_spring1.api.domain.PersonaInput;
import java.util.List;

public interface PersonaService {
	Persona getPersonaById(Integer id);
	List<Persona> getAllPersonas();
	Persona crearPersona(PersonaInput personaInput);
	Persona actualizarPersona(Integer id, PersonaInput personaInput);
	Persona eliminarPersona(Integer id);
	Boolean personasEliminarTodas();
}