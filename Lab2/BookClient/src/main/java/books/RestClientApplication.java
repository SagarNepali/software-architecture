package books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/api/v1/books";

		// add F1
		restTemplate.postForLocation(serverUrl, new Book("F1","F title", "Mr. fbrowns",
				3.99));
		// add G1
		restTemplate.postForLocation(serverUrl, new Book("G1","GI Joe", "jdoe",
				4.99));
		// get G1
		Book book= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "F1");
		System.out.println("----------- get G1-----------------------");
		System.out.println(book.toString());
        // get all
		List<Book> books = getAllBooks(serverUrl);
		System.out.println("----------- get all books-----------------------");
		System.out.println(books);

		// delete G1
		restTemplate.delete(serverUrl+"/{isbn}", "G1");

		// update F1
		book.setAuthor("Mr. F");
		restTemplate.put(serverUrl+"/"+book.getIsbn(), book);

		// get all
		books= getAllBooks(serverUrl);
		System.out.println("----------- get all books-----------------------");
		System.out.println(books);
	}

	public List<Book> getAllBooks (String serverUrl) {
		ResponseEntity<List<Book>> booksResponse =
				restTemplate.exchange(serverUrl,
						HttpMethod.GET, null, new ParameterizedTypeReference<>() {
						});
		return booksResponse.getBody();
	}

	@Bean
	RestOperations restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}
}
