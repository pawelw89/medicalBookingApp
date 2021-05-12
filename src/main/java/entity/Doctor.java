package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor extends User{

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role DOCTOR;

    @Enumerated(EnumType.STRING)
    @Column(name = "speciality")
    private Speciality speciality;

}
