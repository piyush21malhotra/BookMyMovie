package com.example.BookMyShow.Service.ServiceImp;

import com.example.BookMyShow.Converter.TheatreConverter;
import com.example.BookMyShow.DTO.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.TheatreResponseDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Model.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    TheatreSeatsRepository theatreSeatsRepository;

    @Override
    public TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto) {
        TheatreEntity theatreEntity = TheatreConverter.convertEntryDtoToEntity(theatreEntryDto);
        List<TheatreSeatEntity> seats = createTheaterSeat();

        theatreEntity.setTheatreSeatEntityList(seats);
        theatreEntity.setShowEntityList(null);

        for(TheatreSeatEntity theatreSeat : seats) {
            theatreSeat.setTheatreEntity(theatreEntity);
        }

        theatreRepository.save(theatreEntity);
        theatreSeatsRepository.saveAll(seats);

        return TheatreConverter.convertEntityToResponseDto(theatreEntity);
    }
    public List<TheatreSeatEntity> createTheaterSeat() {
        List<TheatreSeatEntity> seats = new ArrayList<>();

        seats.add(setTheatreSeat("1A",100,SeatType.CLASSIC));
        seats.add(setTheatreSeat("1B",100,SeatType.CLASSIC));
        seats.add(setTheatreSeat("1C",100,SeatType.CLASSIC));
        seats.add(setTheatreSeat("1D",100,SeatType.CLASSIC));
        seats.add(setTheatreSeat("1E",100,SeatType.CLASSIC));

        seats.add(setTheatreSeat("2A",200,SeatType.PREMIUM));
        seats.add(setTheatreSeat("2B",200,SeatType.PREMIUM));
        seats.add(setTheatreSeat("2C",200,SeatType.PREMIUM));
        seats.add(setTheatreSeat("2D",200,SeatType.PREMIUM));
        seats.add(setTheatreSeat("2E",200,SeatType.PREMIUM));

        return seats;
    }
    public TheatreSeatEntity setTheatreSeat(String seatNumber, int rate, SeatType seatType) {
        return TheatreSeatEntity.builder()
                .seatNumber(seatNumber)
                .rate(rate)
                .seatType(seatType)
                .build();
    }

    @Override
    public TheatreResponseDto getTheatreById(int id) {
        return TheatreConverter.convertEntityToResponseDto(theatreRepository.findById(id).get());
    }
}
