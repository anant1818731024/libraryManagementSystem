package com.anant.spring.boot.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anant.spring.boot.model.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

	List<Borrowing> findByReturnDate(Date date);

}
