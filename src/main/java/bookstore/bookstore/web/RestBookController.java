package bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;



@RestController
public class RestBookController {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/restbooks")
	public Iterable<Book> getBooks() { 
		
		
		return bookRepository.findAll();
	}
	
	@GetMapping("/restcategories")
	public Iterable<Category> getCategories() { 
		
		
		return categoryRepository.findAll();
	}
	
	
	
}
