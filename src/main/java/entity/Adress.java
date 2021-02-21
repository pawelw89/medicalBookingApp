package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Adress {

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private int zipCode;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

}
