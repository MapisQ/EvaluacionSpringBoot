package org.adaschool.evaluacionspringboot.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.adaschool.evaluacionspringboot.application.lasting.EDestination;
import org.adaschool.evaluacionspringboot.application.lasting.EOrigin;

import java.sql.Time;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookingDto(
        Object id,
        String name,
        String email,
        Date departure_date,
        Time departure_hour,
        EOrigin origin,
        EDestination destination,
        Time duration
) {}
