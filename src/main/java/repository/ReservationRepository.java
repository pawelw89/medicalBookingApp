package repository;

import entity.Reservation;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Long>{

    List<Reservation> listOfReservationsByUserId (long id);

    List<Reservation> listOfReservationsByDoctorId (long id);
}