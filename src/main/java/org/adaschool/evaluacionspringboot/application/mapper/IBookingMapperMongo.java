package org.adaschool.evaluacionspringboot.application.mapper;

import org.adaschool.evaluacionspringboot.domain.dto.BookingDto;
import org.adaschool.evaluacionspringboot.domain.entity.BookingMongo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBookingMapperMongo {
    @Mapping(source = "id", target = "id", qualifiedByName = "objectToString")
    BookingMongo toEntity(BookingDto dto);
    BookingDto toDto(BookingMongo entity);
    List<BookingMongo> toEntityList(List<BookingDto> dtoList);
    List<BookingDto> toDtoList(List<BookingMongo> entityBooking);

    @Named("objectToString")
    default String objectToString(Object obj){
        return obj.toString();
    }
}
