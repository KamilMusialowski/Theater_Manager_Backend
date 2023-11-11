package pl.polsl.musialowski_kamil.theater_manager_backend.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtCreatedDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtCreationDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.mappers.TheatreArtMapper;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TheatreArtService {

    private final TheatreArtRepository theatreArtRepository;
    private final TheatreArtMapper theatreArtMapper;
    private final UserRepository userRepository;
    private final TheaterRepository theaterRepository;
    private final TheatreCharacterRepository theatreCharacterRepository;
    private final ActRepository actRepository;
    private final SceneRepository sceneRepository;
    private final SystemRoleRepository systemRoleRepository;
    private final ArtInvolvedPersonelRepository artInvolvedPersonelRepository;

    public TheatreArtService(TheatreArtRepository theatreArtRepository, TheatreArtMapper theatreArtMapper, UserRepository userRepository, TheaterRepository theaterRepository, TheatreCharacterRepository theatreCharacterRepository, ActRepository actRepository, SceneRepository sceneRepository, SystemRoleRepository systemRoleRepository, ArtInvolvedPersonelRepository artInvolvedPersonelRepository) {
        this.theatreArtRepository = theatreArtRepository;
        this.theatreArtMapper = theatreArtMapper;
        this.userRepository = userRepository;
        this.theaterRepository = theaterRepository;
        this.theatreCharacterRepository = theatreCharacterRepository;
        this.actRepository = actRepository;
        this.sceneRepository = sceneRepository;
        this.systemRoleRepository = systemRoleRepository;
        this.artInvolvedPersonelRepository = artInvolvedPersonelRepository;
    }

    public TheatreArtCreatedDto create(TheatreArtCreationDto theatreArtCreationDto) {
        TheatreArt theatreArt = theatreArtMapper.toEntity(theatreArtCreationDto);

        Optional<User> inputingUser = userRepository.getUserById(theatreArtCreationDto.getInputingUserId());
        theatreArt.setInputingUser(inputingUser.orElseThrow(() -> new NoSuchElementException("User not found")));

        Optional<Theatre> theatre = theaterRepository.getTheatreById(theatreArtCreationDto.getTheaterId());
        theatreArt.setTheatre(theatre.map(Function.identity()).orElse(null));

        TheatreArt savedArt = saveBasicArt(theatreArt);

        TheatreArt finalSavedArt = savedArt;
        theatreArt.setCharacters(theatreArt.getCharacters().stream()
                .peek(character -> {
                    character.setTheatreArt(finalSavedArt);
                    character = theatreCharacterRepository.save(character);
                })
                .collect(Collectors.toSet()));

        TheatreArt finalSavedArt1 = savedArt;
        theatreArt.getActs().forEach(act -> {
            Act savedAct = new Act();
            savedAct.setTheatreArt(finalSavedArt1);
            savedAct.setNumber(act.getNumber());
            savedAct.setTitle(act.getTitle());
            savedAct = actRepository.save(savedAct);
            act.setId(savedAct.getId());

            act.getScenes().forEach(scene -> {
                scene.setAct(act);
                scene.getTheatreCharacters().forEach(character -> {
                    TheatreCharacter savedCharacter = theatreArt.getCharacters().stream()
                            .filter(c -> character.getName().equals(c.getName()))
                            .findFirst().get();
                    character.setId(savedCharacter.getId());
                });
                scene = sceneRepository.save(scene);
            });
        });

        ArtInvolvedPersonel involvedPersonel = new ArtInvolvedPersonel(theatreArtRepository.findById(savedArt.getId()).get(), inputingUser.get(), systemRoleRepository.findBySystemRole(SystemRoleEnum.DIRECTOR).get(), null);
        artInvolvedPersonelRepository.save(involvedPersonel);
        return theatreArtMapper.toDto1(theatreArtRepository.findById(savedArt.getId()).get());
    }

    public TheatreArt saveBasicArt(TheatreArt theatreArt) {
        TheatreArt theatreArtToSave = new TheatreArt();
        theatreArtToSave.setTitle(theatreArt.getTitle());
        theatreArtToSave.setAuthor1(theatreArt.getAuthor1());
        theatreArtToSave.setAuthor2(theatreArt.getAuthor2());
        theatreArtToSave.setAuthor3(theatreArt.getAuthor3());
        theatreArtToSave.setInputingUser(theatreArt.getInputingUser());
        theatreArtToSave.setTheatre(theatreArt.getTheatre());
        theatreArtToSave = theatreArtRepository.save(theatreArtToSave);
        return theatreArtToSave;
    }
}

