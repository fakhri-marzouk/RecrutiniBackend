package com.recrutement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.Application;

@Repository
public interface applicationRepository extends JpaRepository<Application, Long> {
	
}
