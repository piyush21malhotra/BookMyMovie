package com.example.BookMyShow.Converter;


import com.example.BookMyShow.DTO.EntryDto.ShowEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.Model.MovieEntity;
import com.example.BookMyShow.Model.ShowEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ShowConverter {
    public static ShowEntity convertEntryDtoToEntity(ShowEntryDto showEntryDto) {
        return ShowEntity.builder()
                .showDate(showEntryDto.getShowDate())
                .showTime(showEntryDto.getShowTime())
                .build();
    }

    public static ShowResponseDto convertEntityToResponseDto(ShowEntity showEntity) {
        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showDate(showEntity.getShowDate())
                .showTime(showEntity.getShowTime())
                .movieResponseDto(MovieConverter.convertEntityToResponseDto(showEntity.getMovieEntity()))
                .theatreResponseDto(TheatreConverter.convertEntityToResponseDto(showEntity.getTheatreEntity()))
                .build();
    }

    public static List<ShowResponseDto> convertEntityListToResponseDto(List<ShowEntity> listOfShows) {

        List<ShowResponseDto> showResponseDtos = new ArrayList<>();

        for (ShowEntity show : listOfShows) {
            showResponseDtos.add(ShowResponseDto.builder()
                    .id(show.getId())
                    .showDate(show.getShowDate())
                    .showTime(show.getShowTime())
                    .movieResponseDto(MovieConverter.convertEntityToResponseDto(show.getMovieEntity()))
                    .theatreResponseDto(TheatreConverter.convertEntityToResponseDto(show.getTheatreEntity()))
                    .build());
        }
        return showResponseDtos;
    }
}
