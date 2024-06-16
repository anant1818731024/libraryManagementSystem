package com.anant.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.anant.spring.boot.model.Book;
import com.anant.spring.boot.repos.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/")
	public String listBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		
		return "books";
	}
	
	@GetMapping("/book/new")
	public String showCreateForm(Model model) {
		
		Book book = new Book();
		model.addAttribute("book", book);
		
		return "create_book";
	}
	
	@PostMapping("/books")
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:/";
	}
	
	@GetMapping("book/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Book book = bookRepository.findById(id).get();
		model.addAttribute("book", book);
		return "edit_book";
	}
	
	@PostMapping("/book/edit")
	public String updateBook(Book book) {
		bookRepository.save(book);
		return "redirect:/";
	}
	
	@GetMapping("/book/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookRepository.deleteById(id);
		return "redirect:/";
	}
	
}
