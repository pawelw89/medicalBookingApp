package service;

import entity.Patient;
import entity.User;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientByPesel (long pesel);

    Patient updatePatient (long pesel, User user);

    Patient savePatient (Patient patient);

    void deletePatientByPesel (long pesel);
}
