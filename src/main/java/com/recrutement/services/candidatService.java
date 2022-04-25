package com.recrutement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.candidat;

@Service
public class candidatService {
    @Autowired
    private com.recrutement.repositories.candidatRepository candidatRepository ;
    public candidat saveCandidat(candidat candiat){
       return candidatRepository.save(candiat);


    }
    public candidat fetchCandidatByEmail(String email){
        return candidatRepository.findByEmail(email);
    }
}
