package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDto.MovieEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;

import java.util.List;

public interface MovieService {

    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);
    MovieResponseDto getMovieById(int id);
    List<MovieResponseDto> getAllMovies();
}
