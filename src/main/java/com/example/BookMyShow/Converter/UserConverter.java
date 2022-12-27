package com.example.BookMyShow.Converter;

import com.example.BookMyShow.DTO.EntryDto.UserEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.UserResponseDto;
import com.example.BookMyShow.Model.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static UserEntity convertEntryDtoToEntity(UserEntryDto userEntryDto) {
        return UserEntity.builder()
                .name(userEntryDto.getName())
                .mobile(userEntryDto.getMobile())
                .build();
    }

    public static UserResponseDto convertEntityToResponseDto(UserEntity userEntity) {
        return UserResponseDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .mobile(userEntity.getMobile())
                .build();
    }
}
