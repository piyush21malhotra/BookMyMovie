package com.example.BookMyShow.Service.ServiceImp;

import com.example.BookMyShow.Converter.MovieConverter;
import com.example.BookMyShow.Converter.ShowConverter;
import com.example.BookMyShow.Converter.TicketConverter;
import com.example.BookMyShow.DTO.EntryDto.ShowEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.Model.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        ShowEntity showEntity = ShowConverter.convertEntryDtoToEntity(showEntryDto);

        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();
        showEntity.setMovieEntity(movieEntity);

        TheatreEntity theatreEntity = theatreRepository.findById(showEntryDto.getTheatreResponseDto().getId()).get();
        showEntity.setTheatreEntity(theatreEntity);

        List<ShowSeatsEntity> seats = createShowSeats(theatreEntity.getTheatreSeatEntityList(), showEntity);
        showEntity.setShowSeatsEntityList(seats);

        showRepository.save(showEntity);
        showSeatsRepository.saveAll(seats);

        return ShowConverter.convertEntityToResponseDto(showEntity);
    }
    public List<ShowSeatsEntity> createShowSeats(List<TheatreSeatEntity> theatreSeats, ShowEntity show) {

        List<ShowSeatsEntity> showSeats = new ArrayList<>();
        for(TheatreSeatEntity seat : theatreSeats) {
            ShowSeatsEntity showSeat = ShowSeatsEntity.builder()
                    .id(seat.getId())
                    .seatType(seat.getSeatType())
                    .seatNumber(seat.getSeatNumber())
                    .showEntity(show)
                    .rate(seat.getRate())
                    .build();
            showSeats.add(showSeat);
        }
        return showSeats;
    }

    @Override
    public ShowResponseDto getShowById(int id) {
        return ShowConverter.convertEntityToResponseDto(showRepository.findById(id).get());
    }

    @Override
    public List<ShowResponseDto> getAllShows() {
        return ShowConverter.convertEntityListToResponseDto(showRepository.findAll());
    }


}
