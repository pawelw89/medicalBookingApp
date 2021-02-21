package entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Doctor {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "speciality")
    private Speciality speciality;
}
