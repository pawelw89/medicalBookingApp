package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @Pattern(regexp="^[A-Za-z]+$")
    private String name;

    @Column(name = "surname")
    @Pattern(regexp="^[A-Za-z]+$")
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "speciality")
    private Speciality speciality;

    @OneToMany(mappedBy = "doctor")
    private List<Reservation> reservations;

}
