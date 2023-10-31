package pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.TheatreDataModels;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatreCreateDto;

public class TheatreCreateModel {

    private Long userCreatorId;

    private TheatreCreateDto theatreModel;

    public TheatreCreateModel() {
    }

    public TheatreCreateModel(Long userCreatorId, TheatreCreateDto theatreModel) {
        this.userCreatorId = userCreatorId;
        this.theatreModel = theatreModel;
    }

    public Long getUserCreatorId() {
        return userCreatorId;
    }

    public void setUserCreatorId(Long userCreatorId) {
        this.userCreatorId = userCreatorId;
    }

    public TheatreCreateDto getTheatreModel() {
        return theatreModel;
    }

    public void setTheatreModel(TheatreCreateDto theatreModel) {
        this.theatreModel = theatreModel;
    }
}
