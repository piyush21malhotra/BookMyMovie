package com.example.BookMyShow.Converter;

import com.example.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.Model.TicketEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {

    public static TicketResponseDto convertEntityToResponseDto(TicketEntity ticketEntity) {
        return TicketResponseDto.builder()
                .id(ticketEntity.getId())
                .allottedSeat(ticketEntity.getAllottedSeats())
                .amount(ticketEntity.getAmount())
                .userResponseDto(UserConverter.convertEntityToResponseDto(ticketEntity.getUser()))
                .build();
    }
}
