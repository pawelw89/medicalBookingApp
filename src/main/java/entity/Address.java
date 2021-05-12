package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "country")
    @Pattern(regexp="^[A-Za-z]+$")
    private String country;

    @Column(name = "city")
    @Pattern(regexp="^[A-Za-z]+$")
    @Size(min=2, max=30)
    private String city;

    @Column(name = "zip_code")
    @Size(min=5, max=5)
    private int zipCode;

    @Column(name = "street")
    @Pattern(regexp="^[A-Za-z]+$")
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

}
