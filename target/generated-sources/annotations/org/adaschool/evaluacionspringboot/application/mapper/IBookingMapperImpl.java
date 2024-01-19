package org.adaschool.evaluacionspringboot.application.mapper;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.adaschool.evaluacionspringboot.application.lasting.EDestination;
import org.adaschool.evaluacionspringboot.application.lasting.EOrigin;
import org.adaschool.evaluacionspringboot.domain.dto.BookingDto;
import org.adaschool.evaluacionspringboot.domain.entity.Booking;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-19T12:11:40-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class IBookingMapperImpl implements IBookingMapper {

    @Override
    public Booking toEntity(BookingDto dto) {
        if ( dto == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setId( objectToLong( dto.id() ) );
        booking.setName( dto.name() );
        booking.setEmail( dto.email() );
        if ( dto.departure_date() != null ) {
            booking.setDeparture_date( new Date( dto.departure_date().getTime() ) );
        }
        booking.setDeparture_hour( dto.departure_hour() );
        booking.setOrigin( dto.origin() );
        booking.setDestination( dto.destination() );
        booking.setDuration( dto.duration() );

        return booking;
    }

    @Override
    public BookingDto toDto(Booking entity) {
        if ( entity == null ) {
            return null;
        }

        Object id = null;
        String name = null;
        String email = null;
        java.util.Date departure_date = null;
        Time departure_hour = null;
        EOrigin origin = null;
        EDestination destination = null;
        Time duration = null;

        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        departure_date = entity.getDeparture_date();
        departure_hour = entity.getDeparture_hour();
        origin = entity.getOrigin();
        destination = entity.getDestination();
        duration = entity.getDuration();

        BookingDto bookingDto = new BookingDto( id, name, email, departure_date, departure_hour, origin, destination, duration );

        return bookingDto;
    }

    @Override
    public List<Booking> toEntityList(List<BookingDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Booking> list = new ArrayList<Booking>( dtoList.size() );
        for ( BookingDto bookingDto : dtoList ) {
            list.add( toEntity( bookingDto ) );
        }

        return list;
    }

    @Override
    public List<BookingDto> toDtoList(List<Booking> entityBooking) {
        if ( entityBooking == null ) {
            return null;
        }

        List<BookingDto> list = new ArrayList<BookingDto>( entityBooking.size() );
        for ( Booking booking : entityBooking ) {
            list.add( toDto( booking ) );
        }

        return list;
    }
}
