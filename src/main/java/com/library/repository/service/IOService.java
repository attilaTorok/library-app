package com.library.repository.service;

import java.util.List;

/**
 * Basic set of methods for services. With these should the services handle basic get methods and
 * persist the data.
 * 
 * @param <T> the generic type. Should be a DTO.
 * @author Török Attila
 */
public interface IOService<T> {

    /**
     * Get every generic type data from the repository.
     * @since 0.0.1-SNAPSHOT
     * @return a list of the data
     */
    List<T> getData();

    /**
     * Get a generic type data by id.
     * @param id the data id that want to be found
     * @since 0.0.1-SNAPSHOT
     * @return The found data.
     */
    T getById(Long id);

    /**
     * Save the given generic type to the database.
     * @param t the generic type object.
     * @since 0.0.1-SNAPSHOT
     */
    void save(T t);
    
    /**
     * Delete the given generic type to the database.
     * @param t the generic type object.
     */
    void delete(T t);
}
