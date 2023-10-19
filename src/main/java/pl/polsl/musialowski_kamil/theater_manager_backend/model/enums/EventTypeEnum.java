package pl.polsl.musialowski_kamil.theater_manager_backend.model.enums;

public enum EventTypeEnum {

    REHEARSAL("REHEARSAL"),
    ORGANIZATIONAL_MEETING("ORGANIZATIONAL_MEETING"),
    PERFORMANCE("PERFORMANCE"),
    NONE("NONE");

    public final String label;

    private EventTypeEnum(String label) {
        this.label = label;
    }
}
