package az.developia.bookshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshopping.dao.BookDao;
import az.developia.bookshopping.model.Book;
import az.developia.bookshopping.model.SearchModel;

@RestController
@RequestMapping(path="/rest/books")
public class BookRestController {
	
	@Autowired
	private BookDao bookDao;
	
	@GetMapping
	public List<Book> findAll(){
		return bookDao.findAll();
	}

	@GetMapping(path="/{id}")
	public Book findById(@PathVariable(name = "id") Integer id){		
		return bookDao.findById(id).get();
	}

	@PostMapping(path = "/search")
	public List<Book> findAllSearch(@RequestBody SearchModel search){
		return bookDao.findAllSearch(search.getSearch());
	}
	
}
