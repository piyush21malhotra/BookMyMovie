package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDto.UserEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.UserResponseDto;

public interface UserService {

    UserResponseDto addUser(UserEntryDto userEntryDto);

    UserResponseDto getUserById(int id);

}
