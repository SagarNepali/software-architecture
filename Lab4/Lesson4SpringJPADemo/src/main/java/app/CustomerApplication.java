package app;

import java.util.List;

import domain.Address;
import domain.CreditCard;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.CustomerRepository;
import domain.Customer;
import repositories.StudentRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class CustomerApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create customer
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerrepository.save(customer);
		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
		creditCard = new CreditCard("657483342", "Visa", "09/23");
		customer.setCreditCard(creditCard);
		customerrepository.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerrepository.save(customer);

//get customers
		System.out.println(customerrepository.findById(66).get());
		System.out.println(customerrepository.findById(101).get());
		System.out.println("-----------All customers ----------------");
		System.out.println(customerrepository.findAll());
		//update customer
		customer = customerrepository.findById(101).get();
		customer.setEmail("jd@gmail.com");
		customerrepository.save(customer);
		System.out.println("-----------find by phone ----------------");
		System.out.println(customerrepository.findByPhone("0622341678"));
		System.out.println("-----------find by email ----------------");
		System.out.println(customerrepository.findCustomerWithEmail("jj123@acme.com"));
		System.out.println("-----------find customers with a certain type of creditcard ----------------");
		List<Customer> customers = customerrepository.findCustomerWithCreditCardType("Visa");
		for (Customer cust : customers){
			System.out.println(cust);
		}

		System.out.println("-----------find by name ----------------");
		System.out.println(customerrepository.findByName("John doe"));


		// create Student
		Student first = new Student().builder()
				.name("First")
				.phoneNo("1")
				.email("first@student.com")
				.address(new Address(null,"First st", "First city","111"))
				.build();
		studentRepository.save(first);
		Student second = new Student().builder()
				.name("Second")
				.phoneNo("2")
				.email("second@student.com")
				.address(new Address(null,"Second st", "Second city","222"))
				.build();
		studentRepository.save(second);
		Student third = new Student().builder()
				.name("Third")
				.phoneNo("3")
				.email("third@student.com")
				.address(new Address(null,"3rd st", "3rd city","333"))
				.build();
		studentRepository.save(third);
		Student fourth = new Student().builder()
				.name("Fourth")
				.phoneNo("4")
				.email("fourth@student.com")
				.address(new Address(null,"4th st", "4th city","444"))
				.build();
		studentRepository.save(fourth);
		Student fifth = new Student().builder()
				.name("Fifth")
				.phoneNo("5")
				.email("fifth@student.com")
				.address(new Address(null,"5th st", "5th city","555"))
				.build();
		studentRepository.save(fifth);

		System.out.println("-----------All Students ----------------");
		System.out.println(studentRepository.findAll());
		System.out.println("-----------find by name ----------------");
		System.out.println(studentRepository.findAllByName("Second"));
		System.out.println("-----------find by phone ----------------");
		System.out.println(studentRepository.findAllByPhoneNo("3"));
		System.out.println("-----------find by city ----------------");
		System.out.println(studentRepository.findAllStudentsWithAddressCity("4th city"));


	}

}
