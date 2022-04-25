package com.recrutement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.recrutement.entities.Categorie;
import com.recrutement.entities.offre;

import java.util.List;

public interface offreRepository extends JpaRepository<offre,Long> {
    List<offre> findAll();
    List<offre>findByEntrepriseId(@RequestParam Long entrpId);
    static List<offre> findByCategorieIdCat(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
