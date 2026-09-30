package com.peterwhitedev.labs.personas.repository;

import com.capgemini.curso1_spring1.api.domain.Persona;
import java.util.List;

public interface PersonasRepository {
	// Copilot: metodos para recuperar la coleccion de personas y una persona por id e importa las clases necesarias
	Persona getPersonaById(Integer id);
	List<Persona> getAllPersonas();
}