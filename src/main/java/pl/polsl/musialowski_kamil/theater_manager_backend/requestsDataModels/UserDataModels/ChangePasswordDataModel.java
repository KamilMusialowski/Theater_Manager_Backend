package pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.UserDataModels;

public class ChangePasswordDataModel {

    private Long userId;

    private String newPassword;

    public ChangePasswordDataModel() {
    }

    public ChangePasswordDataModel(Long userId, String newPassword) {
        this.userId = userId;
        this.newPassword = newPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
