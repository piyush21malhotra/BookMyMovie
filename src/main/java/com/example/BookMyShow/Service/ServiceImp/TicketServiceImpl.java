package com.example.BookMyShow.Service.ServiceImp;

import com.example.BookMyShow.Converter.TicketConverter;
import com.example.BookMyShow.DTO.BookingReqDto;
import com.example.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Model.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicketById(int id) {
        return TicketConverter.convertEntityToResponseDto(ticketRepository.findById(id).get());
    }

    @Override
    public TicketResponseDto bookTicket(BookingReqDto bookingReqDto) {

        UserEntity userEntity = userRepository.findById(bookingReqDto.getUserId()).get();
        ShowEntity showEntity = showRepository.findById(bookingReqDto.getShowId()).get();

        SeatType seatType = bookingReqDto.getSeatType();
        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getShowSeatsEntityList();
        HashSet<String> requestedSeats = bookingReqDto.getRequestedSeats();

        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();
        String requestedSeatsNotAvailable = "";
        for(ShowSeatsEntity seat : showSeatsEntityList) {
            if((seat.getSeatType().equals(seatType) && requestedSeats.contains(seat.getSeatNumber()))) {
                if(!seat.isBooked()){
                    bookedSeats.add(seat);
                }
                else {
                    requestedSeatsNotAvailable += seat.getSeatNumber() + " ";
                }
            }
        }

        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        if(bookedSeats.size() != requestedSeats.size()) {
            ticketResponseDto.setId(null);
            ticketResponseDto.setAmount(null);
            ticketResponseDto.setAllottedSeat("Requested Seats Not Available: " + requestedSeatsNotAvailable);
            return ticketResponseDto;
        }

        TicketEntity ticketEntity = TicketEntity.builder()
                .showEntity(showEntity)
                .user(userEntity)
                .showSeatsEntityList(bookedSeats)
                .build();

        double amount = 0;
        for(ShowSeatsEntity seat : bookedSeats) {
            seat.setBooked(true);
            seat.setBookedAt(new Date());
            seat.setTicketEntity(ticketEntity);
            amount += seat.getRate();
        }

        ticketEntity.setAmount(amount);
        ticketEntity.setAllottedSeats(convertListOfSeatsEntityToString(bookedSeats));
        ticketEntity.setBookedAt(new Date());

        ticketRepository.save(ticketEntity);

        return TicketConverter.convertEntityToResponseDto(ticketEntity);
    }

    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){

        String str = "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats){

            str += showSeatsEntity.getSeatNumber()+" ";
        }

        return str;

    }
}
