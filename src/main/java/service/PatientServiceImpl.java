package service;

import entity.Patient;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PatientRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service ("userService")
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository PatientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return PatientRepository.findAll();
    }

    @Override
    public Patient getPatientByPesel(long pesel) {
        return PatientRepository.getOne(pesel);
    }

    @Override
    public Patient updatePatient(long pesel, User user) {
        Patient patientFromDatabase = PatientRepository.getOne(pesel);
        patientFromDatabase.setFirstName(user.getFirstName());
        patientFromDatabase.setSurname(user.getSurname());
        // nie wiem czy w ten sposób ustawię adress...
        // patientFromDatabase.setAddress(Patient.);
        PatientRepository.flush();
        Patient updatedPatient = PatientRepository.getOne(pesel);
        return updatedPatient;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return PatientRepository.save(Patient);
    }

    @Override
    public void deletePatientByPesel(long pesel) {
        PatientRepository.deleteById(pesel);
    }
}
