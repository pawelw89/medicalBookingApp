package service;

import entity.Reservation;
import entity.User;
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

    //wymaga dopracowania?
    //nadpisać w tej klasie metodę listOfReservationsByUserPesel ?
    @Override
    public List<Reservation> getAllReservationsByUserPesel(User user, long pesel) {
        return reservationRepository.listOfReservationsByUserPesel(user, pesel);
    }

    @Override
    public Reservation updateReservation(long id, Reservation reservation) {
        Reservation reservationFromDatabase = reservationRepository.getOne(id);
        reservationFromDatabase.setDateAndTime(reservation.getDateAndTime());
        reservationFromDatabase.setDoctor(reservation.getDoctor());
        reservationFromDatabase.setPatient(reservation.getPatient());
        reservationRepository.flush();
        return reservationRepository.getOne(id);
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
