package com.anant.spring.boot.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anant.spring.boot.model.Borrowing;
import com.anant.spring.boot.repos.BookRepository;
import com.anant.spring.boot.repos.BorrowingRepository;
import com.anant.spring.boot.repos.MemberRepository;


@Service
public class BorrowingServiceImpl implements BorrowingService {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	BorrowingRepository borrowingRepository;
	
	
	@Override
	public Borrowing borrowBook(Long bookId, Long memberId) {
		Borrowing borrowing = new Borrowing();
		borrowing.setMember(memberRepository.findById(memberId).get());
		borrowing.setBook(bookRepository.findById(bookId).get());
		
		borrowing.setBorrowedDate(new Date());
		return borrowingRepository.save(borrowing);
	}

	@Override
	public Borrowing returnBook(Long borrowingId) {
		Borrowing borrowing = borrowingRepository.findById(borrowingId).get();
		borrowing.setReturnDate(new Date());
		return borrowingRepository.save(borrowing);
	}

}
