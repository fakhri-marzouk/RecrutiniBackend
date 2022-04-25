package com.recrutement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @CreationTimestamp
    @Column(nullable = true, unique = true, length = 45)
    private Date date;
    @Column(nullable = true, unique = true, length = 45)
    private String description;
    @Column(nullable = true, unique = true, length = 45)
    private String location;
    @Column(nullable = true, unique = true, length = 45)
    private String image_url;
    @Column(nullable = true, unique = true, length = 45)
    private String poste ;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "entrepriseid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private entreprise entreprise;
    @JsonIgnore
   @OneToMany(cascade=CascadeType.ALL, mappedBy="offre")
   private Set<Application> application_offre;
    @ManyToOne
    private Categorie categorie;
}
