package com.example.BookMyShow.Controller;


import com.example.BookMyShow.DTO.EntryDto.UserEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.UserResponseDto;
import com.example.BookMyShow.Service.ServiceImp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> addUser(@RequestBody() UserEntryDto userEntryDto) {
        UserResponseDto user = userService.addUser(userEntryDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable int id) {
        UserResponseDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
