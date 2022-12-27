package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.TheatreResponseDto;

public interface TheatreService {

    TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto);

    TheatreResponseDto getTheatreById(int id);
}
