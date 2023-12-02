package pl.polsl.musialowski_kamil.theater_manager_backend.services.implementations;

import org.springframework.stereotype.Service;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallCreateDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.CreatedTheatreDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatreCreateDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatreEditDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatresListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelUserDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.mappers.HallMapper;
import pl.polsl.musialowski_kamil.theater_manager_backend.mappers.TheatreMapper;
import pl.polsl.musialowski_kamil.theater_manager_backend.mappers.TheatrePersonelMapper;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.Hall;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.Theatre;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatrePersonel;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.User;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.HallRepository;
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
    private final HallRepository hallRepository;
    private final TheatreMapper theatreMapper;
    private final TheatrePersonelMapper theatrePersonelMapper;
    private final HallMapper hallMapper;

    public TheatreServiceImpl(UserRepository userRepository, TheaterRepository theaterRepository, TheatrePersonelRepository theatrePersonelRepository, HallRepository hallRepository, TheatreMapper theatreMapper, TheatrePersonelMapper theatrePersonelMapper, HallMapper hallMapper) {
        this.userRepository = userRepository;
        this.theaterRepository = theaterRepository;
        this.theatrePersonelRepository = theatrePersonelRepository;
        this.hallRepository = hallRepository;
        this.theatreMapper = theatreMapper;
        this.theatrePersonelMapper = theatrePersonelMapper;
        this.hallMapper = hallMapper;
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

    @Override
    public TheatrePersonelDto addPersonel(String email, Long theaterId, String role) {
        Optional<User> personelOptional = userRepository.findByEmail(email);
        User user = null;
        if (personelOptional.isPresent()) {
            user = personelOptional.get();
        }
        Optional<Theatre> theatreOptional = theaterRepository.getTheatreById(theaterId);
        Theatre theater = null;
        if (theatreOptional.isPresent()) {
            theater = theatreOptional.get();
        }

        TheatrePersonel theatrePersonel = new TheatrePersonel(user, theater, SystemRoleEnum.valueOf(role));
        theatrePersonel = theatrePersonelRepository.save(theatrePersonel);
        TheatrePersonelDto theatrePersonelDto = theatrePersonelMapper.toDto(theatrePersonel);
        return theatrePersonelDto;
    }

    @Override
    public Set<TheatrePersonelUserDto> getActors(Long theatreId) {
        Set<TheatrePersonel> theatrePersonels = theatrePersonelRepository.findTheatrePersonelsByTheatre_Id(theatreId).get();
        Set<TheatrePersonelUserDto> theatrePersonelUserDtos = new HashSet<>();
        theatrePersonels.stream().filter(personel -> {
            return personel.getRoleEnum().label.equals("ACTOR");
        }).forEach(personel -> {
            theatrePersonelUserDtos.add(theatrePersonelMapper.toDto1(personel));
        });
        return theatrePersonelUserDtos;
    }

    @Override
    public HallDto addHall(HallCreateDto hallCreateDto, Long theaterId) {
        Optional<Theatre> theatreOptional = theaterRepository.getTheatreById(theaterId);
        Theatre theater = null;
        if (theatreOptional.isPresent()) {
            theater = theatreOptional.get();
        }
        Hall hall = hallMapper.toEntity(hallCreateDto);
        hall.setTheatre(theater);
        hall = hallRepository.save(hall);
        return hallMapper.toDto1(hall);
    }

    @Override
    public Set<HallListDto> getTheatersHalls(Long theaterId) {
        Optional<Theatre> theatreOptional = theaterRepository.getTheatreById(theaterId);
        Theatre theater = null;
        if (theatreOptional.isPresent()) {
            theater = theatreOptional.get();
        }
        Set<Hall> halls = hallRepository.findHallsByTheatre(theater).get();
        Set<HallListDto> result = new HashSet<>();
        halls.forEach(hall -> {
            result.add(hallMapper.toDto2(hall));
        });
        return result;
    }

    @Override
    public CreatedTheatreDto getTheater(Long theaterId) {
        return this.theatreMapper.toDto2(this.theaterRepository.findById(theaterId).get());
    }

    @Override
    public CreatedTheatreDto editTheater(TheatreEditDto theatreEditDto) {
        Theatre theatre = theatreMapper.toEntity(theatreEditDto);
        return this.theatreMapper.toDto2(theaterRepository.save(theatre));
    }

    @Override
    public Set<TheatrePersonelListDto> getPersonel(Long theaterId) {
        Set<TheatrePersonel> theatrePersonels = theatrePersonelRepository.findTheatrePersonelsByTheatre_Id(theaterId).get();
        Set<TheatrePersonelListDto> result = theatrePersonels.stream().map(theatrePersonelMapper::toDto2).collect(Collectors.toSet());
        return result;
    }

    @Override
    public Long deletePersonel(Long personelId) {
        TheatrePersonel theatrePersonel = theatrePersonelRepository.findById(personelId).get();
        theatrePersonelRepository.delete(theatrePersonel);
        return theatrePersonel.getId();
    }
}
