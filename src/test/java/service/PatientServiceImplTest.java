package service;

import entity.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.PatientRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientServiceImpl;

    Patient p1 = new Patient();
    long pesel = 12345678901L;
    Patient p2 = new Patient();
    Patient p3 = new Patient();

    @Test
    void shouldReturnAllPatients() {
        given(patientRepository.findAll()).willReturn(Arrays.asList(p1, p2, p3));

        List<Patient> result = patientServiceImpl.getAllPatients();

        assertThat(result).hasSize(3);
        Assertions.assertEquals(List.of(p1, p2, p3), result);
    }

    @Test
    void shouldReturnPatientByPesel() {
        p1.setPesel(pesel);
        given(patientRepository.getOne(pesel)).willReturn(p1);

        Patient foundPatient = patientServiceImpl.getPatientByPesel(pesel);

        Assertions.assertEquals(p1, foundPatient);
    }

    @Test
    void shouldUpdateAndReturnUpdatedDoctorByPesel() {
        p1.setPesel(pesel);
        p2.setFirstName("Piotr");
        p2.setSurname("Nowak");
        given(patientRepository.getOne(pesel)).willReturn(p2);

        Patient updatedPatient = patientServiceImpl.updatePatient(p1.getPesel(), p2);

        Assertions.assertEquals(p2, updatedPatient);
        Assertions.assertEquals("Piotr", updatedPatient.getFirstName());
    }

    @Test
    void shouldSaveAndReturnNewPatientByPesel() {
        p1.setPesel(pesel);
        given(patientRepository.save(p1)).willReturn(p1);

        Patient patientSaved = patientServiceImpl.savePatient(p1);

        Assertions.assertEquals(p1, patientSaved);
    }

    @Test
    void shouldDeletePatientByPesel() {
        p1.setPesel(pesel);

        patientServiceImpl.deletePatientByPesel(pesel);

        verify(patientRepository, times(1)).deleteById(pesel);
    }
}