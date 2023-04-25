package az.developia.bookshopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.bookshopping.dao.BookDao;
import az.developia.bookshopping.model.Book;

@Controller
public class CustomerController {
	@Autowired
	private BookDao bookDao;
	
	
	@GetMapping(path = "/customer")
	public String showuCustomerPage(Model model) {
		List<Book> books = bookDao.findAll();
		model.addAttribute("books", books);
		return "customer";

	}

}
