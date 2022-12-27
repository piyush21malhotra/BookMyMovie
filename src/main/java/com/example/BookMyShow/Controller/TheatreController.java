package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.TheatreResponseDto;
import com.example.BookMyShow.Service.ServiceImp.TheatreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theatre")
public class TheatreController {

    @Autowired
    TheatreServiceImpl theatreService;

    @PostMapping("/add")
    public ResponseEntity<TheatreResponseDto> addTheatre(@RequestBody() TheatreEntryDto theatreEntryDto) {
        TheatreResponseDto theatre = theatreService.addTheatre(theatreEntryDto);
        return new ResponseEntity<>(theatre, HttpStatus.CREATED);
    }

    @GetMapping("/get-theatre/{id}")
    public ResponseEntity<TheatreResponseDto> getTheatreById(@PathVariable int id) {
        TheatreResponseDto theatre = theatreService.getTheatreById(id);
        return new ResponseEntity<>(theatre, HttpStatus.CREATED);
    }
}
