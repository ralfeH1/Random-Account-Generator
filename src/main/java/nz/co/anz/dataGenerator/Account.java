package nz.co.anz.dataGenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.jfairy.Fairy;
import org.jfairy.producer.person.Person;
import org.jfairy.producer.person.PersonProperties;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Account implements Cloneable {

/*	@Override
	public Account clone() {
		
		return new Gson().fromJson(new Gson().toJson(this), Account.class);
	}
	*/
	
	@SerializedName("accNum")private Long accountNumber;
	private String accountName;
	private BigDecimal balance;
	private Date created;
	private Date updated;
	private CreditCard creditCard;
	private List <Transaction> transactions;
	
	public Account() {
		
	}
	
	public Account(Account copy) {
		this.accountNumber = Long.parseLong(copy.accountNumber.toString());
	}
	
	private static Integer getRandomAcc(){
		Integer number = ThreadLocalRandom.current().nextInt(1,4);
		return number; 
	}
	
	public static List<Account> accounts() {
		List<Account> accounts = new ArrayList<>();
		long id = 1;
		String myAccountName[] = {"Freedom", "Savings", "Internet"};
		for(Integer i = 0; i < getRandomAcc(); i++, id++ ){

			Account account = new Account();
			account.accountNumber = id;
			account.accountName = myAccountName[i];
			account.creditCard = CreditCard.card();
			account.balance = BigDecimal.valueOf(5).setScale(2, RoundingMode.HALF_UP);
			account.updated = new Date();
			account.created = new Date();
			account.transactions = Transaction.transactions();
			accounts.add(account);
		}
		return accounts;
	}
}
