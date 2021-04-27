package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToOne(targetEntity = Doctor.class)
    private Doctor doctor;
}
