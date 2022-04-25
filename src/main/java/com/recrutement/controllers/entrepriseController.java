package com.recrutement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.recrutement.entities.entreprise;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class entrepriseController {
	@Autowired
	com.recrutement.repositories.entrepriseRepository entrepriseRepository;
    @CrossOrigin
    @GetMapping("/entreprises")
  public List<entreprise> getAllEntreprise(){return this.entrepriseRepository.findAll();}

    @CrossOrigin
    @PostMapping("/entreprise")
   public ResponseEntity<entreprise> registerEntrprise(@RequestBody entreprise entrepr){
        return ResponseEntity.ok(entrepriseRepository.save(entrepr));

   }
    @SuppressWarnings("unchecked")
	@CrossOrigin
    @PostMapping("/loginEntreprise")
   public ResponseEntity <entreprise> loginEntreprise(@RequestBody entreprise entrep){
        entreprise entr=entrepriseRepository.findByEmail(entrep.getEmail());
        if(entr.getPassword().equals(entrep.getPassword()))
            return  ResponseEntity.ok(entr);
        return (ResponseEntity<entreprise>) ResponseEntity.internalServerError();
   }


    }

