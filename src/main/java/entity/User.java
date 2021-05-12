package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public abstract class User {

    @Id
    @Column(name = "pesel")
    @Size(min=11, max=11)
    private long pesel;

    private String password;

    @Column(name = "first_name")
    @Pattern(regexp="^[A-Za-z]+$")
    private String firstName;

    @Column(name = "surname")
    @Pattern(regexp="^[A-Za-z]+$")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "user")
    private List <Role> roles;

}
