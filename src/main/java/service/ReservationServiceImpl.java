package service;

import entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReservationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getAllReservationsByUserId(long id) {
        return reservationRepository.listOfReservationsByUserId(id);
    }

    @Override
    public List<Reservation> getAllReservationsByDoctorId(long id) {
        return reservationRepository.listOfReservationsByDoctorId(id);
    }

    @Override
    public Reservation updateReservation(long id, Reservation reservation) {
        Reservation reservationFromDatabase = reservationRepository.getOne(id);
        reservationFromDatabase.setDateAndTime(reservation.getDateAndTime());
        reservationFromDatabase.setDoctor(reservation.getDoctor());
        reservationFromDatabase.setUser(reservation.getUser());
        reservationRepository.flush();
        Reservation updatedReservation = reservationRepository.getOne(id);
        return updatedReservation;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(long id) {
        reservationRepository.deleteById(id);
    }
}
