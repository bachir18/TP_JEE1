package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

@SpringBootApplication
public class TpJee1Application implements CommandLineRunner{
     
	@Autowired  
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(TpJee1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		

		  patientRepository.save(new Patient(null,"hassan",new Date(),false,7));
		  patientRepository.save(new Patient(null,"simo",new Date(),false,7));
		  patientRepository.save(new Patient(null,"moussa",new Date(),false,7));
		  patientRepository.save(new Patient(null,"mssasi",new Date(),true,8));
		  patientRepository.save(new Patient(null,"mjid",new Date(),true,9));

		 
		 
			/*
			 * System.out.println("*****************Tous les patients affiche*********");
			 * patientRepository.findAll().forEach(p->{ System.out.println(p.toString());
			 * }); System.out.println("*************patient par leur id ************");
			 * Patient patient =patientRepository.findById(1L).get();
			 * System.out.println(patient.getNom());
			 */
		
		/*
		 * System.out.println("*************patient par leur alphabet ************");
		 * List<Patient> patient1
		 * =patientRepository.findByNomContains("o",PageRequest.of(0, 2));
		 * patient1.forEach(p->{ System.out.println(p.toString()); });
		 */
		/*
		 * System.out.println("*************patient true or false ************");
		 * List<Patient> patient2 =patientRepository.findByMalade(true);
		 * patient2.forEach(p->{ System.out.println(p.toString()); });
		 * 
		 * System.out.
		 * println("*************patient affiche nom  and true or false ************");
		 * List<Patient> patient3
		 * =patientRepository.findByNomContainsAndMalade("a",true);
		 * patient3.forEach(p->{ System.out.println(p.toString()); });
		 * 
		 * System.out.println("*****************Tous les patients affiche*********");
		 * patientRepository.findAll().forEach(p->{ System.out.println(p.toString());
		 * 
		 * });
		 * 
		 * System.out.
		 * println("*************patient affiche nom  and true or false ************");
		 * Page<Patient> pagePatient =patientRepository.findAll(PageRequest.of(0, 2));
		 * System.out.println("Nombre de pages :"+pagePatient.getTotalPages());
		 * pagePatient.forEach(p->{ System.out.println(p.toString()); });
		 * 
		 * System.out.
		 * println("*************patient affiche nom  and true or false/2 ************"
		 * ); Page<Patient> pagePatient2 =patientRepository.findAll(PageRequest.of(0,
		 * 2)); System.out.println("Nombre de pages :"+pagePatient.getTotalPages());
		 * List<Patient> patientlist=pagePatient2.getContent();
		 * 
		 * patientlist.forEach(p->{ System.out.println(p.toString()); });
		 */
	}

}
