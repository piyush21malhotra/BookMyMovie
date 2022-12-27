package com.example.BookMyShow.DTO;

import com.example.BookMyShow.Enums.SeatType;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingReqDto {

    @NonNull
    private int userId;
    @NonNull
    private int showId;
    @NonNull
    private SeatType seatType;
    @NonNull
    private HashSet<String> requestedSeats;
}
