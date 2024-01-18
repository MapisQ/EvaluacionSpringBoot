package org.adaschool.evaluacionspringboot;

import org.adaschool.evaluacionspringboot.application.GeneralService;
import org.adaschool.evaluacionspringboot.application.exception.BookingException;
import org.adaschool.evaluacionspringboot.application.service.BookingServiceMongo;
import org.adaschool.evaluacionspringboot.domain.entity.BookingMongo;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.GeneralDigest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class EvaluacionSpringBootApplication {

    public static void main(String[] args) throws BookingException {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(EvaluacionSpringBootApplication.class, args);
        GeneralService generalService = applicationContext.getBean(GeneralService.class);
        if (generalService instanceof BookingServiceMongo) {
            generalService.save(new BookingMongo());
            List<BookingMongo> all = generalService.findAll(1, 50);
            for (BookingMongo bookingMongo : all) {
                System.out.println(bookingMongo);
            }
        } else {
            generalService.save(new org.adaschool.evaluacionspringboot.domain.entity.Booking());
            List<org.adaschool.evaluacionspringboot.domain.entity.Booking> all = generalService.findAll(1,50);
            for (org.adaschool.evaluacionspringboot.domain.entity.Booking booking : all) {
                System.out.println(booking);
            }
        }
    }
}
