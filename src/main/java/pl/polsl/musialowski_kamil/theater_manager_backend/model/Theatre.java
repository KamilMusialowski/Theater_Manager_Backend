package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

import java.util.HashSet;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatre")
    private Set<TheatrePersonel> theatrePersonel = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatre")
    private Set<Hall> halls = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatre")
    private Set<TheatreArt> arts = new HashSet<>();

    public Theatre() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public Set<TheatrePersonel> getTheatrePersonel() {
        return theatrePersonel;
    }

    public void setTheatrePersonel(Set<TheatrePersonel> theatrePersonel) {
        this.theatrePersonel = theatrePersonel;
    }

    public Set<Hall> getHalls() {
        return halls;
    }

    public void setHalls(Set<Hall> halls) {
        this.halls = halls;
    }

    public Set<TheatreArt> getArts() {
        return arts;
    }

    public void setArts(Set<TheatreArt> arts) {
        this.arts = arts;
    }
}
