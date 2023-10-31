package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;

@Entity
@Table(name = "users_to_theatres")
public class TheatrePersonel extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    @Enumerated(EnumType.STRING)
    @Column(name = "personel_role", nullable = false)
    private SystemRoleEnum roleEnum;

    public TheatrePersonel() {
    }

    public TheatrePersonel(User user, Theatre theatre, SystemRoleEnum roleEnum) {
        this.user = user;
        this.theatre = theatre;
        this.roleEnum = roleEnum;
    }

    public TheatrePersonel(Long id, User user, Theatre theatre, SystemRoleEnum roleEnum) {
        super(id);
        this.user = user;
        this.theatre = theatre;
        this.roleEnum = roleEnum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public SystemRoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(SystemRoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }
}
