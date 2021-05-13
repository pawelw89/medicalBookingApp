package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "patient")
public class Patient extends User{

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @OneToMany(mappedBy = "patient")
    private List<Reservation> reservations;

}
