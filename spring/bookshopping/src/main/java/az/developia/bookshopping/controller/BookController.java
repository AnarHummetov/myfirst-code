package az.developia.bookshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshopping.dao.BookDao;
import az.developia.bookshopping.model.Book;

@Controller
public class BookController {
	@Autowired
	private BookDao bookDao;

	@GetMapping(path = "/books")
	public String showBooks(Model model) {
		List<Book> books = bookDao.findAll();
		model.addAttribute("books", books);
		return "books";

	}

	@GetMapping(path = "/books/new")
	public String openNewBookPage(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "new-book";

	}

	@PostMapping(path = "/books/new-book-process")
	public String saveBook(@ModelAttribute(name = "book") Book book, Model model) {
		book.setImage("book.jpg");
		book.setUsername("dea");
		bookDao.save(book);
		List<Book> books = bookDao.findAll();
		model.addAttribute("books", books);
		return "books";
	}
	
	@GetMapping(path = "/books/delete/{id}")
	public String deleteBook(@PathVariable(name ="id")Integer id, Model model ) {
	boolean bookExists = bookDao.findById(id).isPresent();
	if (bookExists) {
		bookDao.deleteById(id);
	}else {
		
	}
	List<Book> books = bookDao.findAll();
	model.addAttribute("books", books);
		
		return "redirect:/books";

	}
	
	@GetMapping(path = "/books/edit/{id}")
	public String editBook(@PathVariable(name ="id")Integer id, Model model ) {
	boolean bookExists = bookDao.findById(id).isPresent();
	Book book=null;
	if (bookExists) {
		book=bookDao.findById(id).get();
	}else {
		
	}
	model.addAttribute("book", book);
		
		return "new-book";

	}
}
