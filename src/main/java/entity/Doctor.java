package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Doctor {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "speciality")
    private Speciality speciality;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Speciality getSpeciality() {
        return speciality;
    }
}
