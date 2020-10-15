package com.SpringBootRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SpringBootRest.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public Book findBookById(int id);  //custom created should be named as findBy name, id, or NameAndId	
	
}
