package service;

import entity.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.DoctorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DoctorServiceImplTests {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorServiceImpl doctorServiceImpl;

    Doctor d1 = new Doctor();
    long pesel = 12345678901L;
    Doctor d2 = new Doctor();
    Doctor d3 = new Doctor();

    @Test
    void shouldReturnAllDoctors(){
        given(doctorRepository.findAll()).willReturn(Arrays.asList(d1, d2, d3));

        List<Doctor> result = doctorServiceImpl.getAllDoctors();

        assertThat(result).hasSize(3);
        Assertions.assertEquals(List.of(d1, d2, d3), result);
    }

    @Test
    void shouldReturnDoctorByPesel(){
        d1.setPesel(pesel);
        given(doctorRepository.getOne(pesel)).willReturn(d1);

        Doctor foundDoctor = doctorServiceImpl.findDoctorByPesel(pesel);

        Assertions.assertEquals(d1, foundDoctor);
    }

    @Test
    void shouldUpdateAndReturnUpdatedDoctorByPesel(){
        d1.setPesel(pesel);
        d2.setFirstName("Piotr");
        d2.setSurname("Nowak");
        given(doctorRepository.getOne(pesel)).willReturn(d2);

        Doctor updatedDoctor = doctorServiceImpl.updateDoctor(d1.getPesel(), d2);

        Assertions.assertEquals(d2, updatedDoctor);
        Assertions.assertEquals("Piotr", updatedDoctor.getFirstName());
    }

    @Test
    void shouldSaveAndReturnNewDoctorByPesel() {
        d1.setPesel(pesel);
        given(doctorRepository.save(d1)).willReturn(d1);

        Doctor doctorSaved = doctorServiceImpl.saveDoctor(d1);

        Assertions.assertEquals(d1, doctorSaved);
    }

    @Test
    void shouldDeleteDoctorByPesel() {
        d1.setPesel(pesel);

        doctorServiceImpl.deleteDoctorByPesel(pesel);

        verify(doctorRepository, times(1)).deleteById(pesel);
    }

}
