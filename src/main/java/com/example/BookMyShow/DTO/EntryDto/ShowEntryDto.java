package com.example.BookMyShow.DTO.EntryDto;

import com.example.BookMyShow.DTO.ResponseDto.*;
import com.sun.istack.NotNull;
import lombok.*;
import java.time.*;

@Data
@Builder
public class ShowEntryDto {

    @NotNull
    private LocalDate showDate;
    @NotNull
    private LocalTime showTime;
    @NotNull
    private MovieResponseDto movieResponseDto;
    @NotNull
    private TheatreResponseDto theatreResponseDto;
}
