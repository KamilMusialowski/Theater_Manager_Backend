package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User extends BaseEntity {

    @Column(name = "first_name_1")
    String firstName1;

    @Column(name = "first_name_2")
    String firstName2;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "mail")
    String mail;

    @Column(name = "password")
    String password;

    @Column(name = "phone_number")
    String phoneNumber;

    public User(Long id,
                String firstName1,
                String firstName2,
                String lastName,
                String mail,
                String password,
                String phoneNumber) {
        super(id);
        this.firstName1 = firstName1;
        this.firstName2 = firstName2;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
