package pl.polsl.musialowski_kamil.theater_manager_backend.model.enums;

public enum SexEnum {
    MALE("MALE"),
    FEMALE("FEMALE"),
    NONE("NONE");

    public final String label;

    private SexEnum(String label) {
        this.label = label;
    }
}
