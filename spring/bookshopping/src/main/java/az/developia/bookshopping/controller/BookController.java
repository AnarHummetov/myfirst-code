package az.developia.bookshopping.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import az.developia.bookshopping.config.MySession;
import az.developia.bookshopping.dao.BookDao;
import az.developia.bookshopping.file.StorageService;
import az.developia.bookshopping.model.Book;

@Controller
public class BookController {
	@Autowired
	private BookDao bookDao;

	@Autowired
	private MySession mySession;
	
	@Autowired
	private StorageService storageService;
	
	@GetMapping(path = "/books")
	public String showBooks(Model model) {
		//List<Book> books = bookDao.findAll();
		List<Book> books = bookDao.findAllByUsername(mySession.getUsername());
		model.addAttribute("books", books);
		model.addAttribute("username","İstifadəçi: "+ mySession.getUsername());
		return "books";

	}

	@GetMapping(path = "/books/new")
	public String openNewBookPage(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		model.addAttribute("header", "Yeni kitab");
		return "new-book";

	}

	@PostMapping(path = "/books/new-book-process")
	public String saveBook(@Valid @ModelAttribute(name = "book") Book book,BindingResult result,
			@RequestParam(value = "imageFile",required = false) MultipartFile imageFile,
			Model model) {
		if (result.hasErrors()) {
			return "new-book";
		}
		//book.setImage("book.jpg");
		book.setUsername(mySession.getUsername());
		if (imageFile.isEmpty() && book.getId()!=null) {
			book.setImage(bookDao.findById(book.getId()).get().getImage() );
		}else {
			book.setImage(storageService.store(imageFile));
		}
		
		bookDao.save(book);
		List<Book> books = bookDao.findAll();
		model.addAttribute("books", books);
		return "redirect:/books";
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
	Optional<Book> bookOptional=bookDao.findById(id);
		boolean bookExists = bookOptional.isPresent();
	Book book=new Book();
	if (bookExists) {
		book=bookOptional.get();
	}else {
		
	}
	model.addAttribute("book", book);
	model.addAttribute("header", "Kitab redaktəsi");
	
		return "new-book";

	}
}
