package com.pawelw89.Medical.Booking.App.service;

import entity.Doctor;
import entity.Speciality;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.DoctorRepository;
import service.DoctorServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceImplTests {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorServiceImpl doctorServiceImpl;

    Doctor d1 = new Doctor();
    long pesel = 12345678901l;
    Doctor d2 = new Doctor();
    Doctor d3 = new Doctor();


    @Test
    public void shouldReturnAllDoctors(){

        given(doctorRepository.findAll()).willReturn(Arrays.asList(d1, d2, d3));

        List<Doctor> result = doctorServiceImpl.getAllDoctors();

        assertThat(result).hasSize(3);
    }

    @Test
    public void shouldReturnDoctorByPesel(){
        d1.setPesel(pesel);
        given(doctorRepository.getOne(pesel)).willReturn(d1);

        Doctor foundDoctor = doctorServiceImpl.findDoctorByPesel(pesel);

        assertEquals(d1, foundDoctor);
    }

    //trzeba nad tym jeszcze popracować
    @Test
    public void shouldUpdateDoctor(){
        d1.setPesel(pesel);
        d2.setFirstName("Jan");
        d2.setSurname("Nowak");
        d2.setFirstName("Piotr");
        d2.setSurname("Żyła");
        given(doctorRepository.getOne(pesel)).willReturn(d1);

        Doctor updatedDoctor = doctorServiceImpl.updateDoctor(d1.getPesel(), d2);

        //assertEquals(d1, updatedDoctor);
        verify(doctorRepository, times(1)).save(d1);

    }

    @Test
    public void shouldSaveDoctor() {
        d1.setPesel(pesel);
        given(doctorRepository.save(d1)).willReturn(d1);

        Doctor doctorSaved = doctorServiceImpl.saveDoctor(d1);

        assertEquals(d1, doctorSaved);
    }

    @Test
    public void shouldDeleteDoctor() {
        d1.setPesel(pesel);
        lenient().when(doctorRepository.findById(d1.getPesel())).thenReturn(Optional.of(d1));

        doctorServiceImpl.deleteDoctorByPesel(pesel);

        verify(doctorRepository).deleteById(d1.getPesel());
    }

}
