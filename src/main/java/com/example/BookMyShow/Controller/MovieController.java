package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDto.MovieEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.Service.ServiceImp.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public ResponseEntity<MovieResponseDto> addMovie(@RequestBody() MovieEntryDto movieEntryDto) {
        MovieResponseDto movie = movieService.addMovie(movieEntryDto);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-movie/{id}")
    public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable int id) {
        MovieResponseDto movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movie")
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        List<MovieResponseDto> movie = movieService.getAllMovies();
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

}
