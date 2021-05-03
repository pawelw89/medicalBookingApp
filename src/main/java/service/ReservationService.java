package service;

import entity.Doctor;
import entity.Reservation;
import entity.User;
import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservations();

    List<Reservation> getAllReservationsByUserId (long id);

    List<Reservation> getAllReservationsByDoctorId (long id);

    Reservation updateReservation (long id, Reservation reservation);

    Reservation saveReservation (Reservation reservation);

    void deleteReservationById (long id);

}
