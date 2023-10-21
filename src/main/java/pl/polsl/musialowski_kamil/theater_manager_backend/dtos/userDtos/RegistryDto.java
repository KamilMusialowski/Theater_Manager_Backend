package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.systemRoleDtos.SystemRoleDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SexEnum;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.User}
 */
public record RegistryDto(String firstName1, String firstName2, String lastName, String email, String password,
                          String phoneNumber, SexEnum sex, SystemRoleDto[] systemRoles) implements Serializable {
}

//public class RegistryDto {
//    @JsonProperty("_firstName1")
//    public String firstName1;
//    @JsonProperty("_firstName2")
//    public String firstName2;
//    @JsonProperty("_lastName")
//    public String lastName;
//    @JsonProperty("_email")
//    public String email;
//    @JsonProperty("_password")
//    public String password;
//    @JsonProperty("_phoneNumber")
//    public String phoneNumber;
//    @JsonProperty("_sex")
//    public Sex sex;
//
//    @JsonCreator
//    public RegistryDto(@JsonProperty("_firstName1") String firstName1,
//                       @JsonProperty("_firstName2") String firstName2,
//                       @JsonProperty("_lastName") String lastName,
//                       @JsonProperty("_email") String email,
//                       @JsonProperty("_password") String password,
//                       @JsonProperty("_phoneNumber") String phoneNumber,
//                       @JsonProperty("_sex") Sex sex) {
//        this.firstName1 = firstName1;
//        this.firstName2 = firstName2;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.phoneNumber = phoneNumber;
//        this.sex = sex;
//    }
//
//    public RegistryDto() {
//    }
//}