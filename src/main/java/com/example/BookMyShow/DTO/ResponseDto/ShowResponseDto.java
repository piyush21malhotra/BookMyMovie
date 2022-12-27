package com.example.BookMyShow.DTO.ResponseDto;

import lombok.*;
import java.time.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowResponseDto {

    @NonNull
    private int id;
    @NonNull
    private LocalDate showDate;
    @NonNull
    private LocalTime showTime;
    private MovieResponseDto movieResponseDto;
    private TheatreResponseDto theatreResponseDto;
}
