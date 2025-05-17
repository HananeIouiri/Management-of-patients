package ma.enset.patientsapp.repository;

import ma.enset.patientsapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}