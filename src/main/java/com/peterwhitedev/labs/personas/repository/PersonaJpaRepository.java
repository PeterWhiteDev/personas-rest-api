package com.peterwhitedev.labs.personas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peterwhitedev.labs.personas.entity.PersonaEntity;

@Repository
public interface PersonaJpaRepository extends JpaRepository<PersonaEntity, Integer> {

}
