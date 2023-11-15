package pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.ArtInvolvedPersonelModels;

public class ActorCharacterAssigned {
    private String character;
    private Long actorId;

    public ActorCharacterAssigned() {
    }

    public ActorCharacterAssigned(String character, Long actorId) {
        this.character = character;
        this.actorId = actorId;
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
