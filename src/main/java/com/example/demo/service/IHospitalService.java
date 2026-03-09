package com.example.demo.service;

import com.example.demo.model.Consultation;
import com.example.demo.model.Medecin;
import com.example.demo.model.Patient;
import com.example.demo.model.RendezVous;

public interface IHospitalService {
    Consultation saveConsultation(Consultation consultation);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
}
