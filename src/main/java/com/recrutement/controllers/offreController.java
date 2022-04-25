package com.recrutement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.entities.offre;
import com.recrutement.repositories.offreRepository;
import com.recrutement.repositories.candidatRepository;
import com.recrutement.repositories.entrepriseRepository;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class offreController {
	 	@Autowired
	    entrepriseRepository entrepriseRepository;
	    @Autowired
	    offreRepository offreRepository;
	    @Autowired
	    candidatRepository  candidatRepository;

	    @CrossOrigin
	    @GetMapping("/offres")
	    public List<offre> getAllOffres() {
	        return offreRepository.findAll();
	    }

	    @GetMapping("/offres/{id}")
	    public ResponseEntity<offre> getOffreById(@PathVariable("id") long id) {
	        Optional<offre> offreData = offreRepository.findById(id);
	        if (offreData.isPresent()) {
	            return new ResponseEntity<>(offreData.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }


	    @CrossOrigin
	    @PostMapping("/addOffre/{id}")
	    public offre addOffre(@PathVariable(value="id") long id,@RequestBody offre offre){
	        return  entrepriseRepository.findById(id).map(entreprise -> {
	            offre.setEntreprise(entreprise);
	            return offreRepository.save(offre);
	        }).orElseThrow(()-> new IllegalArgumentException("entreprise "+id+"not found"));
	        }


	    @GetMapping("/entreprise/{entrepriseId}/offres")
	    public ResponseEntity<List<offre>> getAllOffressByEntrepriseId(@PathVariable(value = "entrepriseId") long entrepriseId) {
	        if (!entrepriseRepository.existsById(entrepriseId)) {
	            throw new IllegalArgumentException("Not found Tutorial with id = " + entrepriseId);
	        }
	        List<offre> offres = offreRepository.findByEntrepriseId(entrepriseId);
	        return new ResponseEntity<>(offres, HttpStatus.OK);
	    }

	    @PutMapping("/offres/update/{id}")
	    public ResponseEntity<offre> updateOffre(@PathVariable("id") long id, @RequestBody offre offre) {
	        Optional<offre> offreData = offreRepository.findById(id);
	        if (offreData.isPresent()) {
	            offre _offre = offreData.get();
	            _offre.setPoste(offre.getPoste());
	            _offre.setDescription(offre.getDescription());
	            _offre.setLocation(offre.getLocation());
	            _offre.setImage_url(offre.getImage_url());


	            return new ResponseEntity<>(offreRepository.save(_offre), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @DeleteMapping("/offres/{id}")
	    public ResponseEntity<HttpStatus> deleteOffre(@PathVariable("id") long id) {
	        try {
	            offreRepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    @DeleteMapping("/offres")
	    public ResponseEntity<HttpStatus> deleteAllOffres() {
	        try {
	            offreRepository.deleteAll();
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}