package com.SpringBootRest.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBootRest.entity.Book;
import com.SpringBootRest.service.BookService;

@RestController
public class BookController {
	
	@Autowired(required = true)
	public BookService bookservice;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>>getBookDeatil()
	{
		
		List<Book>list=this.bookservice.getBookDetail();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable("id")int id)
	{
		Book b=null;
		try {
			b=this.bookservice.getBookById(id);
		}
		catch(Exception e){e.printStackTrace();}
		return b;
	}
	
	@PostMapping("/book")
	public Book AddBook(@RequestBody Book book){
	Book bresult=this.bookservice.AddBook(book);
	return book;
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBookById(@PathVariable("id")int id)
	{
		this.bookservice.DeleteBookById(id);
	}
	
	@PutMapping("/book/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id)
	{
		this.bookservice.updateBook(book, id);
		return book;
	}
	
}
