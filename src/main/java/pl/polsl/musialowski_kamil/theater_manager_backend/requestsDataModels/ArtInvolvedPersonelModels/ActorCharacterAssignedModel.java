package pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.ArtInvolvedPersonelModels;

import java.util.Set;

public class ActorCharacterAssignedModel {
    private Long artId;
    private Set<ActorCharacterAssigned> assignedRoles;

    public ActorCharacterAssignedModel() {
    }

    public ActorCharacterAssignedModel(Long artId, Set<ActorCharacterAssigned> assignedRoles) {
        this.artId = artId;
        this.assignedRoles = assignedRoles;
    }

    public Long getArtId() {
        return artId;
    }

    public void setArtId(Long artId) {
        this.artId = artId;
    }

    public Set<ActorCharacterAssigned> getAssignedRoles() {
        return assignedRoles;
    }

    public void setAssignedRoles(Set<ActorCharacterAssigned> assignedRoles) {
        this.assignedRoles = assignedRoles;
    }
}
