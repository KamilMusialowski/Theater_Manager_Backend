package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor extends User{

//    List<pl.polsl.musialowski_kamil.theater_manager_backend.model.Character> charactersList;


    public Actor(Long id,
                 String firstName1,
                 String firstName2,
                 String lastName,
                 String mail,
                 String password,
                 String phoneNumber,
                 Date birthday) {
        super(id, firstName1, firstName2, lastName, mail, password, phoneNumber, birthday);
    }

    public Actor() {
        super();
    }
}
