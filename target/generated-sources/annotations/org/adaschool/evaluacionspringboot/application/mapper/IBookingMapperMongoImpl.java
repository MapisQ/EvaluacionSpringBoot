package org.adaschool.evaluacionspringboot.application.mapper;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.adaschool.evaluacionspringboot.application.lasting.EDestination;
import org.adaschool.evaluacionspringboot.application.lasting.EOrigin;
import org.adaschool.evaluacionspringboot.domain.dto.BookingDto;
import org.adaschool.evaluacionspringboot.domain.entity.BookingMongo;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-18T17:37:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class IBookingMapperMongoImpl implements IBookingMapperMongo {

    @Override
    public BookingMongo toEntity(BookingDto dto) {
        if ( dto == null ) {
            return null;
        }

        BookingMongo bookingMongo = new BookingMongo();

        bookingMongo.setId( objectToString( dto.id() ) );
        bookingMongo.setName( dto.name() );
        bookingMongo.setEmail( dto.email() );
        if ( dto.departure_date() != null ) {
            bookingMongo.setDeparture_date( new Date( dto.departure_date().getTime() ) );
        }
        bookingMongo.setDeparture_hour( dto.departure_hour() );
        bookingMongo.setOrigin( dto.origin() );
        bookingMongo.setDestination( dto.destination() );
        bookingMongo.setDuration( dto.duration() );

        return bookingMongo;
    }

    @Override
    public BookingDto toDto(BookingMongo entity) {
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
    public List<BookingMongo> toEntityList(List<BookingDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BookingMongo> list = new ArrayList<BookingMongo>( dtoList.size() );
        for ( BookingDto bookingDto : dtoList ) {
            list.add( toEntity( bookingDto ) );
        }

        return list;
    }

    @Override
    public List<BookingDto> toDtoList(List<BookingMongo> entityBooking) {
        if ( entityBooking == null ) {
            return null;
        }

        List<BookingDto> list = new ArrayList<BookingDto>( entityBooking.size() );
        for ( BookingMongo bookingMongo : entityBooking ) {
            list.add( toDto( bookingMongo ) );
        }

        return list;
    }
}
