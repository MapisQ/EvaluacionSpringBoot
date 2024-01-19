package org.adaschool.evaluacionspringboot.application.service;

import org.adaschool.evaluacionspringboot.application.GeneralService;
import org.adaschool.evaluacionspringboot.application.exception.BookingException;
import org.adaschool.evaluacionspringboot.application.lasting.EMessage;
import org.adaschool.evaluacionspringboot.application.mapper.IBookingMapperMongo;
import org.adaschool.evaluacionspringboot.domain.dto.BookingDto;
import org.adaschool.evaluacionspringboot.domain.entity.BookingMongo;
import org.adaschool.evaluacionspringboot.domain.repository.BookingMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceMongo implements GeneralService <BookingDto> {

    private final BookingMongoRepository bookingMongoRepository;
    private final IBookingMapperMongo mapper;

    public BookingServiceMongo(@Autowired BookingMongoRepository bookingMongoRepository, IBookingMapperMongo mapper) {
        this.bookingMongoRepository = bookingMongoRepository;
        this.mapper = mapper;
    }


    @Override
    public void save(BookingDto dto) {
        BookingMongo bookingM = mapper.toEntity(dto);
        bookingMongoRepository.save(bookingM);

    }

    @Override
    public BookingDto findById(Object id) throws BookingException {
        BookingMongo bookingM = bookingMongoRepository.findById((String) id)
                .orElseThrow(()-> new BookingException(EMessage.ID_NOT_FOUND));
        return mapper.toDto(bookingM);
    }

    @Override
    public List<BookingDto> findAll(Integer offset, Integer limit) throws BookingException {
        Pageable pageable = PageRequest.of(offset,limit);
        Page<BookingMongo> bookingsM =bookingMongoRepository.findAll(pageable);
        if (bookingsM.getContent().isEmpty()){
            throw new BookingException(EMessage.BOOKING_NOT_FOUND);
        }
        return mapper.toDtoList(bookingsM.getContent());
    }

    @Override
    public void delete(Object id) throws BookingException {
        BookingMongo bookingM = bookingMongoRepository.findById((String) id)
                .orElseThrow(()-> new BookingException(EMessage.ID_NOT_FOUND));
        bookingMongoRepository.delete(bookingM);

    }
}
