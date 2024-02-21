package com.bookmyshow.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookShowResponseDto {
    private Long bookingId;
    private int amount;
    private ResponseStatus responseStatus;

}
enum ResponseStatus {
    SUCCESS, FAILURE
}
