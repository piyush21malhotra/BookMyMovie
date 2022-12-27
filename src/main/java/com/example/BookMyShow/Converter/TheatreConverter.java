package com.example.BookMyShow.Converter;

import com.example.BookMyShow.DTO.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.TheatreResponseDto;
import com.example.BookMyShow.Model.TheatreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {

    public static TheatreEntity convertEntryDtoToEntity(TheatreEntryDto theatreEntryDto) {
        return TheatreEntity.builder()
                .name(theatreEntryDto.getName())
                .address(theatreEntryDto.getAddress())
                .city(theatreEntryDto.getCity())
                .theatreType(theatreEntryDto.getTheatreType())
                .build();
    }

    public static TheatreResponseDto convertEntityToResponseDto(TheatreEntity theatreEntity) {
        return TheatreResponseDto.builder()
                .id(theatreEntity.getId())
                .name(theatreEntity.getName())
                .address(theatreEntity.getAddress())
                .city(theatreEntity.getCity())
                .theatreType(theatreEntity.getTheatreType())
                .build();
    }

}
