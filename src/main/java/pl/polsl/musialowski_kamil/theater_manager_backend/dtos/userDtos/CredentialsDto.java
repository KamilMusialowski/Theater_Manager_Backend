package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos;

import java.io.Serializable;

public record CredentialsDto(String email, char[] password) implements Serializable {


}
