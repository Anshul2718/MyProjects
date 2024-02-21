package com.bookmyshow.demo.services;

import com.bookmyshow.demo.dtos.BookShowRequestDto;
import com.bookmyshow.demo.models.Booking;
import com.bookmyshow.demo.models.User;
import com.bookmyshow.demo.reposities.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookingService {

    private UserRepository userRepository;
    public Booking bookshow(BookShowRequestDto request){

        Optional<User> user  = userRepository.findById(request.getUserId());
        if (!user.isPresent()) {
            throw new UserIsNotValid();

        }


        return new Booking();
    }
}
