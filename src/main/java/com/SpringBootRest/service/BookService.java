package com.SpringBootRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringBootRest.Repository.BookRepository;
import com.SpringBootRest.entity.Book;

@Service
public class BookService {
	
	@Autowired
	public BookRepository bookrepository;
	
	public List<Book>getBookDetail()
	{
		List<Book>list=(List<Book>)this.bookrepository.findAll();
		return  list;
	}
	
//	public Book getBookById(int id) {
//	Book b=null;
//	try {
//	Book b=this.bookrepository.findById(id);
//	}
//	catch(Exception e){
//		e.printStackTrace();
//	}
//	return b;	
//	}
	
	public Book getBookById(int id)
	{
		Book b=this.bookrepository.findBookById(id);
		return b;
	}
	
	public Book AddBook(Book book) {
	Book Result=this.bookrepository.save(book);  //we hv stored data in result
	return  Result;								// then retunrd it to book so in controller we cn perform operation
	} 
	
	public void DeleteBookById(int  id)
	{
		this.bookrepository.deleteById(id);
	}
	
	public void updateBook(Book book,int id)
	{
		book.setId(id);
		this.bookrepository.save(book);
	}



}
