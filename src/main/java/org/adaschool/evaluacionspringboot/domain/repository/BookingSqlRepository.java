package org.adaschool.evaluacionspringboot.domain.repository;

import org.adaschool.evaluacionspringboot.domain.dto.BookingDto;
import org.adaschool.evaluacionspringboot.domain.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingSqlRepository extends JpaRepository<Booking, Long> {

    Page<Booking> findAll(Pageable pageable);
    Optional<Booking> findById(Long id);

}
