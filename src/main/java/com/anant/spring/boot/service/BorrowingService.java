package com.anant.spring.boot.service;

import com.anant.spring.boot.model.Borrowing;

public interface BorrowingService {

	Borrowing borrowBook(Long bookId, Long memberId);
	
	Borrowing returnBook(Long borrowingId);

}
