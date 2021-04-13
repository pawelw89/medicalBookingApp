package entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "user")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_pesel")
    private User user;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

}
