package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "theatres")
public class Theatre extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "city", nullable = false, length = 40)
    private String city;

    @Column(name = "street", nullable = false, length = 60)
    private String street;

    @Column(name = "zip_code", nullable = false, length = 6)
    private String zipCode;

    @Column(name = "voivodeship", nullable = false, length = 40)
    private String voivodeship;

    @Column(name = "country", nullable = false, length = 40)
    private String country;

    @Column(name = "phone_number_1", nullable = false, length = 9)
    private String phoneNumber1;

    @Column(name = "phone_number_2", nullable = false, length = 9)
    private String phoneNumber2;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_to_theatres", joinColumns = @JoinColumn(name = "theatre_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatre")
    private Set<Hall> halls = new HashSet<>();

    public Theatre() {
    }


}
