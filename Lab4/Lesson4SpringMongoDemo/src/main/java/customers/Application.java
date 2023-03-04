package customers;

import customers.domain.Address;
import customers.domain.CreditCard;
import customers.domain.Customer;
import customers.domain.Student;
import customers.repository.CustomerRepository;
import customers.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        // create customer
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
		creditCard = new CreditCard("657483342", "Visa", "09/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		//get customers
		System.out.println(customerRepository.findById(66).get());
		System.out.println(customerRepository.findById(101).get());
		System.out.println("-----------All customers ----------------");
		System.out.println(customerRepository.findAll());
		//update customer
		customer = customerRepository.findById(101).get();
		customer.setEmail("jd@gmail.com");
		customerRepository.save(customer);
		System.out.println("-----------find by phone ----------------");
		System.out.println(customerRepository.findByPhone("0622341678"));
		System.out.println("-----------find by email ----------------");
		System.out.println(customerRepository.findCustomerWithEmail("jj123@acme.com"));
		System.out.println("-----------find customers with a certain type of creditcard ----------------");
		List<Customer> customers = customerRepository.findCustomerWithCreditCardType("Visa");
		for (Customer cust : customers){
			System.out.println(cust);
		}

		System.out.println("-----------find by name ----------------");
		System.out.println(customerRepository.findByName("John doe"));


		//create Students;
		Student first = new Student().builder()
				.studentId(1L)
				.name("First")
				.phoneNo("1")
				.email("first@student.com")
				.address(new Address(1L,"First st", "First city","111"))
				.build();
		studentRepository.save(first);
		Student second = new Student().builder()
				.studentId(2L)
				.name("Second")
				.phoneNo("2")
				.email("second@student.com")
				.address(new Address(2L,"Second st", "Second city","222"))
				.build();
		studentRepository.save(second);
		Student third = new Student().builder()
				.studentId(3L)
				.name("Third")
				.phoneNo("3")
				.email("third@student.com")
				.address(new Address(3L,"3rd st", "3rd city","333"))
				.build();
		studentRepository.save(third);
		Student fourth = new Student().builder()
				.studentId(4L)
				.name("Fourth")
				.phoneNo("4")
				.email("fourth@student.com")
				.address(new Address(4L,"4th st", "Fairfield","444"))
				.build();
		studentRepository.save(fourth);
		Student fifth = new Student().builder()
				.studentId(5L)
				.name("Fifth")
				.phoneNo("5")
				.email("fifth@student.com")
				.address(new Address(5L,"5th st", "Fairfield","555"))
				.build();
		studentRepository.save(fifth);

		System.out.println("-----------All students ----------------");
		System.out.println(studentRepository.findAll());
		System.out.println("-----------All students by name ----------------");
		System.out.println(studentRepository.findAllByName("First"));
		System.out.println("-----------All students by phone ----------------");
		System.out.println(studentRepository.findStudentByPhoneNo("3"));
		System.out.println("-----------All students by City ----------------");
		System.out.println(studentRepository.findAllByAddress_City("Fairfield"));
	}

}
