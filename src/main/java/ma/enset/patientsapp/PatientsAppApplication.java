package ma.enset.patientsapp;

import ma.enset.patientsapp.entities.Patient;
import ma.enset.patientsapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PatientsAppApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null, "Mohammed", new Date(), false, 140));
		patientRepository.save(new Patient(null, "Hanane", new Date(), false, 500));
		patientRepository.save(new Patient(null, "Imane", new Date(), true, 100));
	}
}