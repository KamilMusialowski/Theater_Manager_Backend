package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.Sex;

import java.util.Date;

@Entity
@Table(name = "app_users")
public class User extends BaseEntity {

    @Column(name = "first_name_1", nullable = false, length = 40)
    private String firstName1;

    @Column(name = "first_name_2", length = 40)
    private String firstName2;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "email", nullable = false, length = 80)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number", length = 9)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false, length = 10)
    private Sex sex;

    public User() {
    }

    public User(Long id, String firstName1, String firstName2, String lastName, String email,
                String password, String phoneNumber, Sex sex) {
        super(id);
        this.firstName1 = firstName1;
        this.firstName2 = firstName2;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    public String getFirstName2() {
        return firstName2;
    }

    public void setFirstName2(String firstName2) {
        this.firstName2 = firstName2;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
