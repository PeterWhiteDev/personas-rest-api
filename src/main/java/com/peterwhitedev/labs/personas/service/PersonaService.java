package com.peterwhitedev.labs.personas.service;

import com.peterwhitedev.labs.personas.api.domain.Persona;
import com.peterwhitedev.labs.personas.api.domain.PersonaInput;
import java.util.List;

public interface PersonaService {
	Persona getPersonaById(Integer id);
	List<Persona> getAllPersonas();
	Persona crearPersona(PersonaInput personaInput);
	Persona actualizarPersona(Integer id, PersonaInput personaInput);
	Persona eliminarPersona(Integer id);
	Boolean personasEliminarTodas();
}