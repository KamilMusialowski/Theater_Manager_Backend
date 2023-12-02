package pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.ArtInvolvedPersonelModels;

public class ActorCharacterAssigned {
    private Long id;
    private String character;
    private Long actorId;

    public ActorCharacterAssigned() {
    }

    public ActorCharacterAssigned(Long id, String character, Long actorId) {
        this.id = id;
        this.character = character;
        this.actorId = actorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }
}
