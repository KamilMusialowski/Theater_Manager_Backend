package pl.polsl.musialowski_kamil.theater_manager_backend.model.enums;

public enum Sex {
    MALE("MALE"),
    FEMALE("FEMALE"),
    NONE("NONE");

    public final String label;

    private Sex(String label) {
        this.label = label;
    }
}
