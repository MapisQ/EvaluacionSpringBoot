package org.adaschool.evaluacionspringboot.application.lasting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EMessage {

    BOOKING_NOT_FOUND(HttpStatus.NOT_FOUND,"Reserva no encontrada"),
    ID_NOT_FOUND(HttpStatus.NOT_FOUND,"No fue posible encontrar el ID solicitado");

    private final HttpStatus status;
    private final String message;
}
