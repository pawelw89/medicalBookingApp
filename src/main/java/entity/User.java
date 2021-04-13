package entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "pesel")
    private int pesel;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private Adress adress;

    @OneToOne(mappedBy = "user")
    private Reservation reservation;

    @OneToOne(mappedBy = "user")
    private Role role;

}
