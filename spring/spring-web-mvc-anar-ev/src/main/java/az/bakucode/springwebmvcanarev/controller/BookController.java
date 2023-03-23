package az.bakucode.springwebmvcanarev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/books")
public class BookController {

	
	@GetMapping
	public String showBooks() {
		return "books";
	}
}
