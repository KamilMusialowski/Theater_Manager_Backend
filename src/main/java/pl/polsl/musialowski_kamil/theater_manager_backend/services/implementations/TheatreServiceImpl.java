package pl.polsl.musialowski_kamil.theater_manager_backend.services.implementations;

import org.springframework.stereotype.Service;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.CreatedTheatreDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatreCreateDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatresListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.mappers.TheatreMapper;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.Theatre;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatrePersonel;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.User;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.TheaterRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.TheatrePersonelRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.UserRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.services.TheatreService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class TheatreServiceImpl implements TheatreService {

    private final UserRepository userRepository;
    private final TheaterRepository theaterRepository;
    private final TheatrePersonelRepository theatrePersonelRepository;
    private final TheatreMapper theatreMapper;

    public TheatreServiceImpl(UserRepository userRepository,
                              TheaterRepository theaterRepository,
                              TheatrePersonelRepository theatrePersonelRepository,
                              TheatreMapper theatreMapper) {
        this.userRepository = userRepository;
        this.theaterRepository = theaterRepository;
        this.theatrePersonelRepository = theatrePersonelRepository;
        this.theatreMapper = theatreMapper;
    }

    @Override
    public CreatedTheatreDto create(Long creatorId, TheatreCreateDto theatreCreateDto) {
        Optional<User> userOptional = userRepository.getUserById(creatorId);
        User user = null;
        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            return null;
        }
        Theatre theatre = theatreMapper.toEntity(theatreCreateDto);
        theatre = theaterRepository.save(theatre);
        TheatrePersonel director = new TheatrePersonel(user, theatre, SystemRoleEnum.MANAGER);
        director = theatrePersonelRepository.save(director);
        return theatreMapper.toDto2(theatre);
    }

    @Override
    public Set<TheatresListDto> getTheatersOfManager(Long managerId) {
        Optional<Set<Theatre>> theatresOptional = theaterRepository
                .getTheatresForUserIdAndRole(managerId, SystemRoleEnum.MANAGER);
        Set<Theatre> theatres = theatresOptional.orElse(new HashSet<>());
        Set<TheatresListDto> theatersDtos = theatres.stream()
                .map(theatreMapper::toTheatresListDto)
                .collect(Collectors.toSet());
        return theatersDtos;
    }
}
