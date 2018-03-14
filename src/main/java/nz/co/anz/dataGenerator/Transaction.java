package nz.co.anz.dataGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Transaction  implements Serializable{


	private static final long serialVersionUID = 6009716650988064911L;

	public static enum Type {
		EFTPOS,
		DIRECT_DEBIT,
		PAYMENT
	}

	@SerializedName("transNum") private Long transactionNumber;
	private Date created;
	private Type type;
	private String details;
	private BigDecimal withdrawl;
	private BigDecimal deposit;
	private BigDecimal balance;

	public Long getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(Long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public BigDecimal getWithdrawl() {
		return withdrawl;
	}
	public void setWithdrawl(BigDecimal withdrawl) {
		this.withdrawl = withdrawl;
	}
	public BigDecimal getDeposit() {
		return deposit;
	}
	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	private static Integer getRandomTransaction(){
		Integer number = ThreadLocalRandom.current().nextInt(1,10);
		return number; 
	}
	private static Integer getRandomEnum(){
		Integer number = ThreadLocalRandom.current().nextInt(0,3);
		return number; 
	}

	@Override
	public int hashCode() {
		return transactionNumber != null ? transactionNumber.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Transaction)
			return obj.hashCode() == hashCode();
		else{
			return super.equals(obj);
		}

	}

	public static List<Transaction> transactions() {
		List<Transaction> transactions = new ArrayList<>();
		for(int i = 0; i < getRandomTransaction(); i++){
			switch(Type.values()[getRandomEnum()])
			{
				case EFTPOS:
					transactions.add(eftpos(1L, i));
					break;
				case DIRECT_DEBIT:
					transactions.add(directDebit(1L, i));
					break;
				case PAYMENT:
					transactions.add(payment(1L, i));
					break;	
			}
		}
		return transactions;
	}
	
	private static Transaction eftpos(Long transactionNumber, int i) {
		Transaction eftposTransaction = new Transaction();
		eftposTransaction.transactionNumber = transactionNumber + i;
		eftposTransaction.balance = BigDecimal.valueOf(2).setScale(2, RoundingMode.HALF_UP);
		eftposTransaction.created = new Date();
		eftposTransaction.details = "J & M";
		eftposTransaction.type = Type.EFTPOS;
		eftposTransaction.withdrawl = BigDecimal.valueOf(1).setScale(2, RoundingMode.HALF_UP);
		eftposTransaction.deposit = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP);
		return eftposTransaction;
	}
	private static Transaction directDebit(Long transactionNumber, int i) {
		Transaction directDebitTransaction = new Transaction();
		directDebitTransaction.transactionNumber = transactionNumber + i;
		directDebitTransaction.balance = BigDecimal.valueOf(2).setScale(2, RoundingMode.HALF_UP);
		directDebitTransaction.created = new Date();
		directDebitTransaction.details = "J & M";
		directDebitTransaction.type = Type.DIRECT_DEBIT;
		directDebitTransaction.withdrawl = BigDecimal.valueOf(1).setScale(2, RoundingMode.HALF_UP);
		directDebitTransaction.deposit = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP);
		return directDebitTransaction;
	}
	private static Transaction payment(Long transactionNumber, int i) {
		Transaction paymentTransaction = new Transaction();
		paymentTransaction.transactionNumber = transactionNumber + i;
		paymentTransaction.balance = BigDecimal.valueOf(2).setScale(2, RoundingMode.HALF_UP);
		paymentTransaction.created = new Date();
		paymentTransaction.details = "ANZ Bank";
		paymentTransaction.type = Type.PAYMENT;
		paymentTransaction.withdrawl = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP);
		paymentTransaction.deposit = BigDecimal.valueOf(1).setScale(2, RoundingMode.HALF_UP);
		return paymentTransaction;
	}
}