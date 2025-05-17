package ma.enset.patientsapp;

import ma.enset.patientsapp.entities.Patient;
import ma.enset.patientsapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class PatientsAppApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//patientRepository.save(new Patient(null, "Mohammed", new Date(), false, 140));
		//patientRepository.save(new Patient(null, "Hanane", new Date(), false, 500));
		//patientRepository.save(new Patient(null, "Imane", new Date(), true, 100));

	List<Patient> patients = patientRepository.findAll();
        patients.forEach(p -> {
		System.out.println(p.toString());
	});

        System.out.println("******************");
	Patient patient = patientRepository.findById(Long.valueOf(1)).get();
        System.out.println("Patient with ID 1: \n" + patient.toString());

        System.out.println("******************");
	List<Patient> patientList = patientRepository.findByNomContains("Han");
        patientList.forEach(p -> {
		System.out.println(p.toString());
	});

        System.out.println("******************");
	List<Patient> patientList2 = patientRepository.search("%Han%");

        patientList2.forEach(p -> {
		System.out.println(p.toString());
	});

        System.out.println("******************");
	Patient patientToUpdate = patientRepository.findById(Long.valueOf(1)).orElse(null);
        if (patientToUpdate != null) {
		patientToUpdate.setScore(999);
		patientRepository.save(patientToUpdate);
		System.out.println("Patient mis à jour : " + patientToUpdate.toString());
	}

        System.out.println("******************");
        patientRepository.deleteById(Long.valueOf(2));
        System.out.println("🗑️ Patient avec ID 2 supprimé.");
}
}
