package entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @OneToOne(mappedBy = "doctor")
    private Reservation reservation;

}
