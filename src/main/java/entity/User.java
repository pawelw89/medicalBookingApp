package entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "pesel")
    //@Size(min=11, max=11)
    private int pesel;

    @Column(name = "first_name")
    //@Pattern(regex=....)
    private String firstName;

    @Column(name = "surname")
    //@Pattern(regex=....)
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Adress adress;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "user")
    private List <Role> roles;

}
