package bookstore.bookstore.web;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bookstore.bookstore.domain.BookRepository;
import ch.qos.logback.classic.Logger;


	
	@Controller
	public class BookController {
		private static final org.slf4j.Logger Log = LoggerFactory.getLogger(BookController.class);
		@Autowired
		BookRepository bookRepository;
		
		@GetMapping("/index")
		public String Bookstore(Model model) {
		return "index";
		}
		
		@GetMapping("books")
		public String showBooks(Model model) {
			model.addAttribute("books", bookRepository.findAll());
			return "books";
		}
		
		
		
	}
