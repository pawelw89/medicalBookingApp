package service;

import entity.Reservation;
import entity.User;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservations();

    List<Reservation> getAllReservationsByUserPesel(User user, long pesel);

    Reservation updateReservation (long id, Reservation reservation);

    Reservation saveReservation (Reservation reservation);

    void deleteReservationById (long id);

}
