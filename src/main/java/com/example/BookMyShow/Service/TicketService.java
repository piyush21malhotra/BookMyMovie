package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.BookingReqDto;
import com.example.BookMyShow.DTO.ResponseDto.TicketResponseDto;

public interface TicketService {

    TicketResponseDto getTicketById(int id);

    TicketResponseDto bookTicket(BookingReqDto bookingReqDto);
}
