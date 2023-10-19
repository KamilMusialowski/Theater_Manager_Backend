package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SexEnum;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.User}
 */
public class UserAllDto implements Serializable {
    private Long id;
    private String firstName1;
    private String firstName2;
    private String lastName;
    private String email;
    private String phoneNumber;
    private SexEnum sex;
    private String token;

    public UserAllDto() {
    }

    public UserAllDto(Long id, String firstName1, String firstName2, String lastName, String email,
                      String phoneNumber, SexEnum sex, String token) {
        this.id = id;
        this.firstName1 = firstName1;
        this.firstName2 = firstName2;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    public String getFirstName2() {
        return firstName2;
    }

    public void setFirstName2(String firstName2) {
        this.firstName2 = firstName2;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}