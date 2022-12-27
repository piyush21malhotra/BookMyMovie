package com.example.BookMyShow.Converter;

import com.example.BookMyShow.DTO.EntryDto.MovieEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.Model.MovieEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class MovieConverter {

    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto) {
        return MovieEntity.builder()
                .name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate())
                .build();
    }

    public static MovieResponseDto convertEntityToResponseDto(MovieEntity movieEntity) {
        return MovieResponseDto.builder()
                .id(movieEntity.getId())
                .name(movieEntity.getName())
                .releaseDate(movieEntity.getReleaseDate())
                .build();
    }

    public static List<MovieResponseDto> convertEntityListToResponseDto(List<MovieEntity> listOfMovies) {

        List<MovieResponseDto> movieResponseDtos = new ArrayList<>();

        for(MovieEntity movie : listOfMovies) {
            movieResponseDtos.add(MovieResponseDto.builder()
                    .id(movie.getId())
                    .name(movie.getName())
                    .releaseDate(movie.getReleaseDate())
                    .build());
        }
        return movieResponseDtos;
    }
}
