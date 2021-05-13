package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty
    @Pattern(regexp="^[A-Za-z]+$", message = "Enter only letters")
    private String country;

    @Column(name = "city")
    @NotEmpty
    @Pattern(regexp="^[A-Za-z]+$", message = "Enter only letters")
    @Size(min=2, max=30)
    private String city;

    @Column(name = "zip_code")
    @NotEmpty
    @Pattern(regexp="^[\\d]+$", message = "Enter only digits, without '-'")
    @Size(min=5, max=5, message = "Enter exactly 5 digits")
    private int zipCode;

    @Column(name = "street")
    @Pattern(regexp="^[A-Za-z]+$", message = "Enter only letters")
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

}
