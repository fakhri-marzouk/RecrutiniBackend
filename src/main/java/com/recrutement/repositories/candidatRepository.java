package com.recrutement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recrutement.entities.candidat;

public interface candidatRepository extends JpaRepository<candidat,Long> {
    candidat findByEmail(String email);
}
