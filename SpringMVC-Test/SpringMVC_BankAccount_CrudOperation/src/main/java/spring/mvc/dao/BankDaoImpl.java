package spring.mvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.mvc.model.Bank;
@Repository
public class BankDaoImpl implements BankDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addNewAccount(Bank bank) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(bank);
	}

	public List<Bank> getAllBankAccount() {
		List<Bank> bank = sessionFactory.getCurrentSession().createQuery("from Bank").list();
		return bank;
	}

	public void deleteBankAccount(Integer bankId) {
		// TODO Auto-generated method stub
		Bank bank=(Bank)sessionFactory.getCurrentSession().get(Bank.class, bankId);
		if(bank !=null)
		{
			this.sessionFactory.getCurrentSession().delete(bank);
		}
	}

	public Bank updateBankAccount(Bank bank) {
		sessionFactory.getCurrentSession().update(bank);
		return bank;
	}

	public Bank getBankAccount(int bankid) {
		Bank bank=(Bank) sessionFactory.getCurrentSession().get(Bank.class, bankid);

		return bank;
	}

	public Bank UpdateCreditAmount(Bank bank) {
		sessionFactory.getCurrentSession().update(bank);
		return bank;
	}

	public Bank UpdateWithdrawalAmount(Bank bank) {
		sessionFactory.getCurrentSession().update(bank);
		return bank;
	}

}
