package org.adaschool.evaluacionspringboot.application.mapper;


import org.adaschool.evaluacionspringboot.application.mapper.base.IBaseMapper;
import org.adaschool.evaluacionspringboot.domain.dto.BookingDto;
import org.adaschool.evaluacionspringboot.domain.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBookingMapper extends IBaseMapper {

    @Mapping(source = "id", target = "id", qualifiedByName = "objectToLong")
    Booking toEntity(BookingDto dto);
    BookingDto toDto(Booking entity);
    List<Booking> toEntityList(List<BookingDto> dtoList);
    List<BookingDto> toDtoList(List<Booking> entityBooking);

    @Named("objectToLong")
    default Long objectToLong(Object obj){
        return Long.valueOf(obj.toString());
    }
}
