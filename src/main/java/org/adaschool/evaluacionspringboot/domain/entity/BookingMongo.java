package org.adaschool.evaluacionspringboot.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.adaschool.evaluacionspringboot.application.lasting.EDestination;
import org.adaschool.evaluacionspringboot.application.lasting.EOrigin;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@ToString
@Document(collection = "Booking")
public class BookingMongo {
    @Id
    private String id;
    private String name;
    private String email;
    private Date departure_date;
    private Time departure_hour;
    private EOrigin origin;
    private EDestination destination;
    private Time duration;

}
