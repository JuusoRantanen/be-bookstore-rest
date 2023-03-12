package bookstore.bookstore.web;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.CategoryRepository;
import ch.qos.logback.classic.Logger;




	
	@Controller
	public class BookController {
		private static final org.slf4j.Logger Log = LoggerFactory.getLogger(BookController.class);
		@Autowired
		BookRepository bookRepository;
		@Autowired
		CategoryRepository categoryRepository;
		
		@GetMapping("/index")
		public String Bookstore(Model model) {
		return "index";
		}
		
		@GetMapping("books")
		public String showBooks(Model model) {
			model.addAttribute("books", bookRepository.findAll());
			return "books";
		}
		
		@GetMapping("/addBook")
		public String addBook(Model model) {
			Log.info("Moving to create new book...");
			model.addAttribute("book", new Book());
			model.addAttribute("categories", categoryRepository.findAll());
			return "newBook";
		}
		
		@GetMapping("editBook/{id}")
		public String editBook(@PathVariable("id") Long id, Model model) {
			model.addAttribute("editBook", bookRepository.findById(id));
			model.addAttribute("categories", categoryRepository.findAll());
			return "editBook";
		}
		
		@PostMapping(value="/saveBook")
		public String saveBook(Book book) {
			
			//Check if there are errors based on validation
			
			bookRepository.save(book);
			return "redirect:books";
		}
		
		@GetMapping("categories")
		public String showCategories(Model model) {
			model.addAttribute("categories", categoryRepository.findAll());
			return "categories";
		}
		
		@GetMapping("delete/{id}")
		public String deleteBook(@PathVariable("id") Long id, Model model) {
			
			bookRepository.deleteById(id);

			return "redirect:/books";
		}
		
		
		
	}
