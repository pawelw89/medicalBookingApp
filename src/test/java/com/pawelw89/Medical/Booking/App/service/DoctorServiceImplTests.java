package com.pawelw89.Medical.Booking.App.service;

import entity.Doctor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.DoctorRepository;
import service.DoctorServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceImplTests {


    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorServiceImpl doctorServiceImpl;

    @Test
    public void  shouldReturnAllDoctors(){
        List<Doctor> doctors = new ArrayList<>();
        Doctor doctor1 = new Doctor();
        Doctor doctor2 = new Doctor();
        Doctor doctor3 = new Doctor();
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);

        List <Doctor> savedDoctors = doctorRepository.saveAll(doctors);
        List <Doctor> foundDoctors = doctorServiceImpl.getAllDoctors();

        assertEquals(savedDoctors, foundDoctors);
    }

    @Test
    public void shouldReturnDoctorByPesel(){
        long pesel = 1234567890;
        Doctor doctor = new Doctor();
        doctor.setPesel(pesel);
        Doctor savedDoctor = doctorRepository.save(doctor);
        Doctor foundDoctor = doctorServiceImpl.findDoctorByPesel(pesel);

        assertEquals(savedDoctor, foundDoctor);
    }

}
