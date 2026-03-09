package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Medecin;

public interface MedecinReopsitory extends JpaRepository<Medecin,Long>{
    public Medecin findByNom(String nom);
}
