package spring.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.dao.BankDao;
import spring.mvc.model.Bank;
@Service
@Transactional
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDao bankDao; 
	
	@Transactional
	public void addNewAccount(Bank bank) {
		// TODO Auto-generated method stub
		bankDao.addNewAccount(bank);
	}
	@Transactional
	public List<Bank> getAllBankAccount() {
		// TODO Auto-generated method stub
		return bankDao.getAllBankAccount();
	}
	
	@Transactional
	public void deleteBankAccount(Integer bankId) {
		// TODO Auto-generated method stub
		bankDao.deleteBankAccount(bankId);
	}
	
	@Transactional
	public Bank updateBankAccount(Bank bank) {
		// TODO Auto-generated method stub
		return bankDao.updateBankAccount(bank);
	}

	public Bank getBankAccount(int bankid) {
		// TODO Auto-generated method stub
		return bankDao.getBankAccount(bankid);
	}
	public Bank UpdateCreditAmount(Bank bank) {
		// TODO Auto-generated method stub
		return bankDao.UpdateCreditAmount(bank);
	}
	public Bank UpdateWithdrawalAmount(Bank bank) {
		// TODO Auto-generated method stub
		return bankDao.UpdateWithdrawalAmount(bank);
	}

}
