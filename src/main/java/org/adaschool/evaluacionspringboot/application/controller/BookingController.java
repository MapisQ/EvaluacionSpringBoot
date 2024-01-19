package org.adaschool.evaluacionspringboot.application.controller;

import org.adaschool.evaluacionspringboot.application.GeneralService;
import org.adaschool.evaluacionspringboot.application.exception.BookingException;
import org.adaschool.evaluacionspringboot.application.service.BookingService;
import org.adaschool.evaluacionspringboot.domain.dto.BookingDto;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.GeneralDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    private final GeneralService generalService;

    public BookingController(GeneralService generalService) {
        this.generalService = generalService;
    }


    @PostMapping("/saveBooking")
    public ResponseEntity<?> saveBooking(@RequestBody BookingDto bookingDto){
        generalService.save(bookingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/search/{idBooking}")
    public ResponseEntity<?> searchBookingById(@PathVariable("idBooking") Integer idBooking) throws BookingException {
        generalService.findById(idBooking);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/bookings/{offset}/{limit}")
    public ResponseEntity<?> searchBookings (@PathVariable Integer offset,@PathVariable Integer limit) throws BookingException {
        List<BookingDto> bookingDtoList = generalService.findAll(offset, limit);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{idBooking}")
    public ResponseEntity<?> deleteBooking (@RequestBody BookingDto bookingDto) throws BookingException {
        generalService.delete(bookingDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
