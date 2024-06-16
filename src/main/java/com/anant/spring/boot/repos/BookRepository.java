package com.anant.spring.boot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anant.spring.boot.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
