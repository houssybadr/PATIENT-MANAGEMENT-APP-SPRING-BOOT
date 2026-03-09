package com.example.demo.model;

import java.util.Collection;

import org.springframework.data.jpa.repository.query.JpqlQueryBuilder.RenderContext;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private boolean malade;

    @OneToMany(
        mappedBy="patient",
        fetch = FetchType.LAZY
    )
    private Collection<RendezVous> rendezVous;
   

}
