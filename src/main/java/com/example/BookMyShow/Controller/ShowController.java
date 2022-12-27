package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDto.ShowEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.Service.ServiceImp.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ResponseEntity<ShowResponseDto> addShow(@RequestBody() ShowEntryDto showEntryDto) {
        ShowResponseDto show = showService.addShow(showEntryDto);
        return new ResponseEntity<>(show, HttpStatus.CREATED);
    }

    @GetMapping("/get-show/{id}")
    public ResponseEntity<ShowResponseDto> getShowById(@PathVariable int id) {
        ShowResponseDto show = showService.getShowById(id);
        return new ResponseEntity<>(show, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-shows")
    public ResponseEntity<List<ShowResponseDto>> getAllShows() {
        List<ShowResponseDto> shows = showService.getAllShows();
        return new ResponseEntity<>(shows, HttpStatus.CREATED);
    }
}
