package com.example.BookMyShow.DTO;

import com.example.BookMyShow.DTO.ResponseDto.*;
import lombok.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class TicketDto {

    @NonNull
    private int id;
    @NonNull
    private HashSet<String> allottedSeat;
    @NonNull
    private double amount;

    private ShowResponseDto showResponseDto;
    private UserResponseDto userResponseDto;
}
