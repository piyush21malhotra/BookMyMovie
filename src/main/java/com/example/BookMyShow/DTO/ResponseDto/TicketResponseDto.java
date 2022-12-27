package com.example.BookMyShow.DTO.ResponseDto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketResponseDto {


    private Integer id;
    private String allottedSeat;
    private Double amount;
    UserResponseDto userResponseDto;

}
