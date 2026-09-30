package com.peterwhitedev.labs.personas.repository;

import com.peterwhitedev.labs.personas.api.domain.Persona;
import java.util.List;

public interface PersonasRepository {
	// Copilot: metodos para recuperar la coleccion de personas y una persona por id e importa las clases necesarias
	Persona getPersonaById(Integer id);
	List<Persona> getAllPersonas();
}