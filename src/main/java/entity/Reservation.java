package entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "user")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_pesel")
    private User user;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

    @Column(name = "doctor")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
