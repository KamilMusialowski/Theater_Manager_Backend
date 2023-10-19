package pl.polsl.musialowski_kamil.theater_manager_backend.model.enums;

public enum SystemRoleEnum {

    MANAGER("MANAGER"),
    DIRECTOR("DIRECTOR"),
    ACTOR("ACTOR"),
    NONE("NONE");

    public final String label;

    private SystemRoleEnum(String label) {
        this.label = label;
    }
}
