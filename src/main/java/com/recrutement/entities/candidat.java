package com.recrutement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nom;
    private String prenom ;
    @Column(nullable = false, unique = false, length = 45)
    private String password ;

    @Column(nullable = false, unique = true, length = 45)
    private String email;
    
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy="candidat")
    private Set<Application> application_candidat;
}
