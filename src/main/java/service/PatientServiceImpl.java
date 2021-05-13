package service;

import entity.Patient;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PatientRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service ("patientService")
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientByPesel(long pesel) {
        return patientRepository.getOne(pesel);
    }

    @Override
    public Patient updatePatient(long pesel, User user) {
        Patient patientFromDatabase = patientRepository.getOne(pesel);
        patientFromDatabase.setFirstName(user.getFirstName());
        patientFromDatabase.setSurname(user.getSurname());
        // nie wiem czy w ten sposób ustawię adress...
        // patientFromDatabase.setAddress(Patient.);
        patientRepository.flush();
        return patientRepository.getOne(pesel);
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatientByPesel(long pesel) {
        patientRepository.deleteById(pesel);
    }
}
