package BookStore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;


@DataJpaTest
public class BookRepositoryTests {
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void findByTitleShouldReturnAuthor() {
		Book book = bookRepository.findByTitle("Jäniksen vuosi");
		assertThat(book.getAuthor().equalsIgnoreCase("Arto Paasilinna"));
		
	}
	
	
	/*@Test
	public void findCarOwner() {
		List<Car> cars = bookRepository.findByOwnerLastName("Watson");
		assertThat(cars).hasSize(1);		
	}
	
	@Test
	public void saveCar() {
		Car car = new Car();
		carRepository.save(car);
		assertNotEquals(car.getId(), null);

	}
	
	@Test
	public void updateCar() {
		Optional<Car> car = carRepository.findById((long) 1);
		assertNotEquals(car.get().getId(), null);
		car.get().setBrand("testi");
		List<Car> cars = carRepository.findByBrand("testi");
		assertThat(cars).hasSize(1);		
	}*/
	
}

