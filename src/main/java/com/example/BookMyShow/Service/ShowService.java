package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDto.ShowEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.DTO.ResponseDto.ShowResponseDto;

import java.util.List;

public interface ShowService {

    ShowResponseDto addShow(ShowEntryDto showEntryDto);

    ShowResponseDto getShowById(int id);

    List<ShowResponseDto> getAllShows();
}
