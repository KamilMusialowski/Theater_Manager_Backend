package pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.RehearsalDataModels;

import java.time.LocalDateTime;

public class RehearsalCreateDataModel {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long hallId;
    private Long artId;

    public RehearsalCreateDataModel() {
    }

    public RehearsalCreateDataModel(LocalDateTime startDate, LocalDateTime endDate, Long hallId, Long artId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.hallId = hallId;
        this.artId = artId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public Long getArtId() {
        return artId;
    }

    public void setArtId(Long artId) {
        this.artId = artId;
    }
}
