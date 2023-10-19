package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;

@Entity
@Table(name = "system_roles")
public class SystemRole extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false)
    private SystemRoleEnum systemRole;

    public SystemRole() {
        this.systemRole = SystemRoleEnum.NONE;
    }

    public SystemRole(Long id, SystemRoleEnum systemRole) {
        super(id);
        this.systemRole = systemRole;
    }

    public SystemRoleEnum getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(SystemRoleEnum systemRole) {
        this.systemRole = systemRole;
    }
}
