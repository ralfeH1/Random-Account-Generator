package nz.co.anz.dataGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.jfairy.Fairy;
import org.jfairy.producer.person.Person;
import org.jfairy.producer.person.PersonProperties;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Customer {
	@SerializedName("fName") private String firstName;
	@SerializedName("lName") private String lastName;
	@SerializedName("custNum") private Long customerNumber;
	private Address address;
	private List<Account> accounts;

	public static List<Customer> customers(){
		List<Customer> customers = new ArrayList<>();
		long id = 0;
		Fairy fair = Fairy.create();
		for(int i = 0; i < 10; i++, id++)
		{
			Person p = fair.person(ThreadLocalRandom.current().nextBoolean() ? PersonProperties.male() : PersonProperties.female());
			p.firstName();
			Customer customer = new Customer();
			customer.customerNumber = id;
			customer.firstName = p.firstName();
			customer.lastName = p.lastName();
			customer.address = Address.address();
			customer.accounts = Account.accounts();
			customers.add(customer);
		}
		return customers;
	}

}
