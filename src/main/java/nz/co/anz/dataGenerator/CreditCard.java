package nz.co.anz.dataGenerator;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CreditCard {
	
	@SerializedName("cardNum")private Long cardNumber;
	private String name;
	private Date expiry;
	private String issuer;
	private String cvv;
	
	public static CreditCard card() {
		CreditCard card = new CreditCard();
		card.name = "J.SUN";
		card.expiry = new Date();
		card.issuer = "ANZ";
		card.cvv = getRandomCvv();
		return card;
	}
	private static String getRandomCvv(){
		Integer number = ThreadLocalRandom.current().nextInt(100,1000);
		return Integer.toString(number); 
	}
}
