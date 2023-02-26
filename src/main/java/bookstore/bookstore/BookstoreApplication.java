package bookstore.bookstore;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	

	

@Bean
public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository categoryRepository) {
	return (args) -> {
		log.info("save few books");
		categoryRepository.save(new Category("Adventure"));
		categoryRepository.save(new Category("Novel"));
		categoryRepository.save(new Category("Kids"));
		categoryRepository.save(new Category("Mystery"));
		categoryRepository.save(new Category("Crime"));
		
		bookRepository.save(new Book("Harry Potter 1", "J.K. Rowling", "12345-54321", 1998, 28.50, categoryRepository.findByName("Adventure").get(0)));
		bookRepository.save(new Book("Harry Potter 2", "J.K. Rowling", "98765-56789", 2002, 33.50, categoryRepository.findByName("Adventure").get(0)));
		bookRepository.save(new Book("Rum diary", "Hunter S. Thompson", "18274-85347", 1998, 18.30, categoryRepository.findByName("Mystery").get(0)));
		bookRepository.save(new Book("Jäniksen vuosi", "Arto Paasilinna", "53485-43284", 1975, 8.30, categoryRepository.findByName("Novel").get(0)));
		
		
		log.info("print books");
		for (Book book: bookRepository.findAll()) {
			log.info(book.toString());
			};};}

/*@Override
public void run(String... args) throws Exception {

	System.out.println("LUODAAN DEMODATAA");
	// Add car object and link to owners and save these to db
	Book book1 = new Book("Harry Potter 1", "J.K. Rowling", "12345-54321", 1998, 28.50);
	bookRepository.save(book1);
	bookRepository.save(new Book("Harry Potter 2", "J.K. Rowling", "98765-56789", 2002, 33.50));
	bookRepository.save(new Book("Rum diary", "Hunter S. Thompson", "18274-85347", 1998, 18.30));

	log.info("Tulostetaan IDEn konsoliin autot:");
	for (Book book: bookRepository.findAll()) {
		log.info(book.toString());
	}

}*/}
