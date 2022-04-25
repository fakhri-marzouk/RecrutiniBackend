package com.recrutement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entities.entreprise;

@Repository
public interface entrepriseRepository extends JpaRepository<entreprise,Long> {
    entreprise findByEmail(String email);

}
