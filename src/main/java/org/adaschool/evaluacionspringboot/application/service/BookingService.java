package org.adaschool.evaluacionspringboot.application.service;

import org.adaschool.evaluacionspringboot.application.GeneralService;
import org.adaschool.evaluacionspringboot.application.exception.BookingException;
import org.adaschool.evaluacionspringboot.application.lasting.EMessage;
import org.adaschool.evaluacionspringboot.application.mapper.IBookingMapper;
import org.adaschool.evaluacionspringboot.domain.dto.BookingDto;
import org.adaschool.evaluacionspringboot.domain.entity.Booking;
import org.adaschool.evaluacionspringboot.domain.repository.BookingSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements GeneralService<BookingDto> {

    private final BookingSqlRepository bookingSqlRepository;
    private final IBookingMapper mapper;

    public BookingService(BookingSqlRepository bookingSqlRepository, IBookingMapper mapper) {
        this.bookingSqlRepository = bookingSqlRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(BookingDto dto) {
        Booking booking = mapper.toEntity(dto);
        bookingSqlRepository.save(booking);
    }

    @Override
    public BookingDto findById(Object id) throws BookingException {
        Booking booking = bookingSqlRepository.findById((Long) id)
                .orElseThrow(()-> new BookingException(EMessage.ID_NOT_FOUND));
        return mapper.toDto(booking);
    }

    @Override
    public List<BookingDto> findAll(Integer offset, Integer limit) throws BookingException {
        Pageable pageable = PageRequest.of(offset,limit);
        Page<Booking> bookings =bookingSqlRepository.findAll(pageable);
        if (bookings.getContent().isEmpty()){
            throw new BookingException(EMessage.BOOKING_NOT_FOUND);
        }
        return mapper.toDtoList(bookings.getContent());
    }

    @Override
    public void delete(Object id) throws BookingException {
        Booking booking = bookingSqlRepository.findById((Long) id)
                .orElseThrow(()-> new BookingException(EMessage.ID_NOT_FOUND));
        bookingSqlRepository.delete(booking);
    }
}