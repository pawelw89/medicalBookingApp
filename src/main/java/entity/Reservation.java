package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

    @ManyToOne
    @JoinColumn(name = "patient_pesel")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_pesel")
    private Doctor doctor;

    //foreign key
    //@Column(name="user_id")
    //private long userId;
}
