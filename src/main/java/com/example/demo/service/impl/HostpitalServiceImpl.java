package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Consultation;
import com.example.demo.model.Medecin;
import com.example.demo.model.Patient;
import com.example.demo.model.RendezVous;
import com.example.demo.repository.ConsulltationRepository;
import com.example.demo.repository.MedecinReopsitory;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.RendezVousRepository;
import com.example.demo.service.IHospitalService;

public class HostpitalServiceImpl implements IHospitalService{

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    MedecinReopsitory medecinReopsitory;
    @Autowired
    ConsulltationRepository consulltationRepository;
    @Autowired
    RendezVousRepository rendezVousRepository;

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return this.consulltationRepository.save(consultation);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return this.rendezVousRepository.save(rendezVous);
    }

    @Override
    public Patient savePatient(Patient patient) {
        return this.patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return this.medecinReopsitory.save(medecin);
    }
}
