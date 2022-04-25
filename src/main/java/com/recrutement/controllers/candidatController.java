package com.recrutement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.recrutement.entities.candidat;
import com.recrutement.repositories.candidatRepository;

@CrossOrigin
@RestController
public class candidatController {
	@Autowired
    private candidatRepository candidatRepository;


    @CrossOrigin
    @PostMapping("/candidat")
    public ResponseEntity<candidat> registerCandidat(@RequestBody candidat candi){
        return ResponseEntity.ok(candidatRepository.save(candi));

    }
    @SuppressWarnings("unchecked")
	@CrossOrigin
    @PostMapping("/loginCandidat")
    public ResponseEntity <candidat> loginCandidat(@RequestBody candidat candid){
        candidat cand=candidatRepository.findByEmail(candid.getEmail());
        if(cand.getPassword().equals(candid.getPassword()))
            return  ResponseEntity.ok(cand);
        return (ResponseEntity<candidat>) ResponseEntity.internalServerError();
    }
}

