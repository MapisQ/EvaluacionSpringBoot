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

    public static void main(String[] args) {
        SpringApplication.run(EvaluacionSpringBootApplication.class, args);
    }
}
