package com.library.service;

import java.util.List;

/**
 * Basic set of methods for services. With these should the services handle basic get methods and
 * persist the data.
 * @param <T> the generic type. Should be a DTO.
 * @since 0.0.1-SNAPSHOT
 * @author Török Attila
 */
public interface IOService<T> {

    /**
     * Get every generic type data from the repository.
     * @param <T> the generic type.
     * @since 0.0.1-SNAPSHOT
     * @return a list of the data
     */
    List<T> getData();

    /**
     * Get a generic type data by id.
     * @param <T> the generic type.
     * @since 0.0.1-SNAPSHOT
     * @return The found data.
     */
    T getById(Long id);

    /**
     * Save the given generic type to the database.
     * @param <T> the generic type.
     * @since 0.0.1-SNAPSHOT
     */
    void save(T t);
}
