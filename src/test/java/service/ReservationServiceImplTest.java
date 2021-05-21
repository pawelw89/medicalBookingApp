package service;

import entity.Patient;
import entity.Reservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.ReservationRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ReservationServiceImplTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationServiceImpl;

    Reservation r1 = new Reservation();
    long id = 1L;
    Reservation r2 = new Reservation();
    Reservation r3 = new Reservation();

    @Test
    void shouldReturnAllReservations() {
        given(reservationRepository.findAll()).willReturn(Arrays.asList(r1, r2, r3));

        List<Reservation> result = reservationServiceImpl.getAllReservations();

        assertThat(result).hasSize(3);
        Assertions.assertEquals(List.of(r1, r2, r3), result);
    }

    @Test
    void shouldReturnAllReservationsByUserPesel() {

    }

    @Test
    void shouldUpdateAndReturnUpdatedReservationById() {
        r1.setId(id);
        Patient patient = new Patient();
        r2.setPatient(patient);
        given(reservationRepository.getOne(id)).willReturn(r2);

        Reservation updatedReservation = reservationServiceImpl.updateReservation(r1.getId(), r2);

        Assertions.assertEquals(r2, updatedReservation);
        Assertions.assertEquals(patient, updatedReservation.getPatient());
    }

    @Test
    void shouldSaveAndReturnNewReservationById() {
        r1.setId(id);
        given(reservationRepository.save(r1)).willReturn(r1);

        Reservation reservationSaved = reservationServiceImpl.saveReservation(r1);

        Assertions.assertEquals(r1, reservationSaved);
    }

    @Test
    void ShouldDeleteReservationById() {
        r1.setId(id);

        reservationServiceImpl.deleteReservationById(id);

        verify(reservationRepository, times(1)).deleteById(id);
    }
}