package spring.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bank")
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Account_No;
	private String Account_Holder_Name;
	private String Account_Holder_Address;
	private int balance;
	private int deposit_amount;
	private int widrawl_amount;
	
	public Bank(int account_No, String account_Holder_Name, String account_Holder_Address, int balance,
			int deposit_amount, int widrawl_amount) {
		super();
		Account_No = account_No;
		Account_Holder_Name = account_Holder_Name;
		Account_Holder_Address = account_Holder_Address;
		this.balance = balance;
		this.deposit_amount = deposit_amount;
		this.widrawl_amount = widrawl_amount;
	}

	public Bank() {
		super();
	}

	public int getAccount_No() {
		return Account_No;
	}

	public void setAccount_No(int account_No) {
		Account_No = account_No;
	}

	public String getAccount_Holder_Name() {
		return Account_Holder_Name;
	}

	public void setAccount_Holder_Name(String account_Holder_Name) {
		Account_Holder_Name = account_Holder_Name;
	}

	public String getAccount_Holder_Address() {
		return Account_Holder_Address;
	}

	public void setAccount_Holder_Address(String account_Holder_Address) {
		Account_Holder_Address = account_Holder_Address;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getDeposit_amount() {
		return deposit_amount;
	}

	public void setDeposit_amount(int deposit_amount) {
		this.deposit_amount = deposit_amount;
	}

	public int getWidrawl_amount() {
		return widrawl_amount;
	}

	public void setWidrawl_amount(int widrawl_amount) {
		this.widrawl_amount = widrawl_amount;
	}
	
	
	
}
