package org.adaschool.evaluacionspringboot.domain.repository;

import org.adaschool.evaluacionspringboot.domain.entity.Booking;
import org.adaschool.evaluacionspringboot.domain.entity.BookingMongo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingMongoRepository extends MongoRepository<BookingMongo, String> {
    Page<BookingMongo> findAll(Pageable pageable);
    Optional<BookingMongo> findById(String id);

}
