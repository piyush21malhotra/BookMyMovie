package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.BookingReqDto;
import com.example.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.Service.ServiceImp.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("/book")
    public ResponseEntity<TicketResponseDto> bookTicket(@RequestBody() BookingReqDto bookingReqDto) {
        TicketResponseDto ticket = ticketService.bookTicket(bookingReqDto);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @GetMapping("/get-ticket/{id}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable int id) {
        TicketResponseDto ticket = ticketService.getTicketById(id);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }
}
