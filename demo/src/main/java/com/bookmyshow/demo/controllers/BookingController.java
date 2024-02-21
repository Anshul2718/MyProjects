package com.bookmyshow.demo.controllers;

import com.bookmyshow.demo.dtos.BookShowRequestDto;
import com.bookmyshow.demo.dtos.BookShowResponseDto;
import com.bookmyshow.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookShowResponseDto bookShow(BookShowRequestDto request){
        return bookingService.bookshow(request);


    }
}
