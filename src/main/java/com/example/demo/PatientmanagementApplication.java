package com.example.demo;

import java.sql.Date;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Consultation;
import com.example.demo.model.Medecin;
import com.example.demo.model.Patient;
import com.example.demo.model.RendezVous;
import com.example.demo.model.StatusRV;
import com.example.demo.repository.ConsulltationRepository;
import com.example.demo.repository.MedecinReopsitory;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.RendezVousRepository;

@SpringBootApplication
public class PatientmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientmanagementApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
		PatientRepository patientRepository,
		MedecinReopsitory medecinReopsitory,
		RendezVousRepository rendezVousRepository,
		ConsulltationRepository consulltationRepository
	
	){
		return args->{
			Stream
				.of("patient1","patient2","patient3")
				.forEach(name ->{
					Patient patient=Patient.builder()
												.email(name+"@gmail.com")
												.nom(name)
												.dateNaissance(new Date(0))
												.build();
					patientRepository.save(patient);
				});

			Stream
				.of("medecin1","medecin2","medecin3")
				.forEach(nom->{
					Medecin medecin =Medecin.builder()
												.email(nom+"@gmail.com")
												.nom(nom)
												.specialite("specialite de "+nom)
												.build();

					medecinReopsitory.save(medecin);
				});

			Patient patient1=patientRepository.findByNom("patient1");
			Medecin medecin1=medecinReopsitory.findByNom("medecin1");

			RendezVous rendezVous=RendezVous.builder()
							.dateRDV(new Date(0))
							.patient(patient1)
							.medecin(medecin1)
							.status(StatusRV.DONE)
							.build();
			rendezVous.setId(rendezVousRepository.save(rendezVous).getId());
			

			consulltationRepository.save(
				Consultation.builder()
								.dateConsultation(new Date(0))
								.rapportConsultation("RAPPORT cONSULTATION")
								.rendezVous(rendezVous)
								.build()
			);
		};
	}

}
