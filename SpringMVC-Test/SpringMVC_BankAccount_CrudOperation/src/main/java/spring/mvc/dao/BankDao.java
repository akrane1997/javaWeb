package spring.mvc.dao;

import java.util.List;

import spring.mvc.model.Bank;



public interface BankDao {
	public void addNewAccount(Bank bank);
	 
    public List<Bank> getAllBankAccount();
 
    public void deleteBankAccount(Integer bankId);
 
    public Bank updateBankAccount(Bank bank);
 
    public Bank getBankAccount(int bankid);
    
    public Bank UpdateCreditAmount(Bank bank);
    
    public Bank UpdateWithdrawalAmount(Bank bank);
    
}
