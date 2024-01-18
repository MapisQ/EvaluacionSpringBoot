package org.adaschool.evaluacionspringboot.application;

import org.adaschool.evaluacionspringboot.application.exception.BookingException;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {

    void save(T dto);
    T findById(Object id) throws BookingException;
    List<T> findAll(Integer offset, Integer limit) throws BookingException;
    void delete(Object id) throws BookingException;
}
