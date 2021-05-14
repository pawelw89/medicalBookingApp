package com.pawelw89.Medical.Booking.App.service;

import entity.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.DoctorRepository;
import service.DoctorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceImplTests {


    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorServiceImpl doctorServiceImpl;


    @Test
    public void shouldReturnDoctorByPesel(){
        long pesel = 1234567890;
        Doctor doctor = new Doctor();
        doctor.setPesel(pesel);
        Doctor savedDoctor = doctorRepository.saveAndFlush(doctor);

        Doctor foundDoctor = doctorRepository.getOne(pesel);

        Assertions.assertEquals(savedDoctor, foundDoctor);
    }

}
