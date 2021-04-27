package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "country")
    //@Pattern
    private String country;

    @Column(name = "city")
    //@Pattern
    //@Size(min=3, max=30)
    private String city;

    @Column(name = "zip_code")
    //@Size(min=5, max=5)
    private int zipCode;

    @Column(name = "street")
    //@Pattern
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    @OneToOne(mappedBy = "user")
    private User user;

}
