package az.developia.bookshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshopping.dao.BookDao;
import az.developia.bookshopping.model.Book;

@RestController
@RequestMapping(path="/books")
public class BookRestController {
	
	@Autowired
	private BookDao bookDao;
	
	@GetMapping
	public List<Book> showBooks(){
		return bookDao.findAll();
	}

}
