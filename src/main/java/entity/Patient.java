package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "patient")
public class Patient extends User{

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role PATIENT;

}
