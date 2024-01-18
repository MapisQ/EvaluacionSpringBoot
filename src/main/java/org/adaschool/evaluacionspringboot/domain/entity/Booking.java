package org.adaschool.evaluacionspringboot.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.adaschool.evaluacionspringboot.application.lasting.EDestination;
import org.adaschool.evaluacionspringboot.application.lasting.EOrigin;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "booking")
public class Booking {
    @Id
    @SequenceGenerator(name = "id_booking", sequenceName = "id_booking")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_booking_generator")
    private Long id;
    private String name;
    private String email;
    private Date departure_date;
    private Time departure_hour;
    private EOrigin origin;
    private EDestination destination;
    private Time duration;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && Objects.equals(name, booking.name) && Objects.equals(email, booking.email) && Objects.equals(departure_date, booking.departure_date) && Objects.equals(departure_hour, booking.departure_hour) && origin == booking.origin && destination == booking.destination && Objects.equals(duration, booking.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, departure_date, departure_hour, origin, destination, duration);
    }
}
