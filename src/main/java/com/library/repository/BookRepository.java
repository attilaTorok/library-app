package com.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.domain.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
