package com.bookmyshow.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {
    private Date startTime;
    private Date endTime;
    /*
       Show     Movie
         1        1
         M        1
     */
    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Screen screen;
}
