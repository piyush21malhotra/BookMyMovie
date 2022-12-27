package com.example.BookMyShow.Service.ServiceImp;

import com.example.BookMyShow.Converter.UserConverter;
import com.example.BookMyShow.DTO.EntryDto.UserEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.UserResponseDto;
import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserEntryDto userEntryDto) {

        UserEntity userEntity = UserConverter.convertEntryDtoToEntity(userEntryDto);
        userRepository.save(userEntity);
        return UserConverter.convertEntityToResponseDto(userEntity);
    }

    @Override
    public UserResponseDto getUserById(int id) {
        return UserConverter.convertEntityToResponseDto(userRepository.findById(id).get());
    }
}
