package pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.HallDataModels;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallCreateDto;

public class HallCreateDataModel {

    private HallCreateDto hallModel;
    private Long theaterId;

    public HallCreateDataModel() {
    }

    public HallCreateDataModel(HallCreateDto hallModel, Long theaterId) {
        this.hallModel = hallModel;
        this.theaterId = theaterId;
    }

    public HallCreateDto getHallModel() {
        return hallModel;
    }

    public void setHallModel(HallCreateDto hallModel) {
        this.hallModel = hallModel;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }
}
