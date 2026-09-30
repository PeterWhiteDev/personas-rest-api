package com.peterwhitedev.labs.personas.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.peterwhitedev.labs.personas.api.PersonasApi;
import com.peterwhitedev.labs.personas.api.domain.Persona;
import com.peterwhitedev.labs.personas.api.domain.PersonaInput;
import com.peterwhitedev.labs.personas.service.PersonaService;
import com.peterwhitedev.labs.personas.web.error.PersonaNotFoundException;

import jakarta.validation.Valid;

@RestController
public class PersonasController implements PersonasApi {
	// Copilot: inyecta el servicio de personas
	private final PersonaService personaService;

	public PersonasController(PersonaService personaService) {
		this.personaService = personaService;
	}

	@Override
	public ResponseEntity<List<Persona>> personasGet() {
		List<Persona> personas = personaService.getAllPersonas();
		return ResponseEntity.ok(personas);
	}

	@Override
	public ResponseEntity<Persona> personasIdGet(Integer id) {
		Persona persona = personaService.getPersonaById(id);
		if (persona == null) {
			throw new PersonaNotFoundException("Persona no encontrada");
		}
		return ResponseEntity.ok(persona);
	}

	@Override
	public ResponseEntity<Persona> personasPost(@Valid @RequestBody PersonaInput personaInput) {
		// Implementación ejemplo: crea una nueva persona usando el servicio
		Persona creada = personaService.crearPersona(personaInput);
		return ResponseEntity.status(HttpStatus.CREATED).body(creada);
	}

	@Override
	public ResponseEntity<Persona> personasIdPut(Integer id, @Valid @RequestBody PersonaInput personaInput) {
		// Implementación ejemplo: actualizar persona usando el servicio
		Persona actualizada = personaService.actualizarPersona(id, personaInput);
		return ResponseEntity.ok(actualizada);
	}

	@Override
	public ResponseEntity<Persona> personasIdDelete(Integer id) {
		// Implementación ejemplo: eliminar persona usando el servicio
		Persona eliminada = personaService.eliminarPersona(id);
		return ResponseEntity.ok(eliminada);
	}
	
	
	@Override
	public ResponseEntity<Boolean> personasDelete() {
		// Implementación ejemplo: eliminar persona usando el servicio
		Boolean resultado = personaService.personasEliminarTodas();
		return ResponseEntity.ok(resultado);
	}
}