package spring.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.model.Bank;
import spring.mvc.service.BankService;

@Controller
public class BankController {

	@Autowired
	private BankService bankService;

	@RequestMapping(value="/")
	public ModelAndView listBankAccount(ModelAndView model) throws IOException {
		List<Bank> listBank = bankService.getAllBankAccount();
		model.addObject("listBank",listBank);
		model.setViewName("home");
		return model;
	}

	@RequestMapping (value ="/newBankAccount", method = RequestMethod.GET)
	public ModelAndView AddNewBankAccount(ModelAndView model) {
		Bank bank = new Bank();
		model.addObject("bank",bank);
		model.setViewName("BankAccountForm");	
		return model;	
	}

	@RequestMapping(value = "/saveBankAccount", method = RequestMethod.POST)
	public ModelAndView saveBankAccount(@ModelAttribute("bank") Bank bank) {
		int id=bank.getAccount_No();
		System.out.println("Id "+id);
		if (bank.getAccount_No() == 0) 
		{
			bank.setBalance(10000);
			bankService.addNewAccount(bank);
		} 
		else 
		{
			bankService.updateBankAccount(bank);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteBankAccount", method = RequestMethod.GET)
	public ModelAndView deleteBankAccount(HttpServletRequest request) {
		int accountNo = Integer.parseInt(request.getParameter("account_No"));
		bankService.deleteBankAccount(accountNo);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editBankAccount", method = RequestMethod.GET)
	public ModelAndView editBankAccount(HttpServletRequest request) {
		int accountNo = Integer.parseInt(request.getParameter("account_No"));
		System.out.println("account No: "+accountNo);
		Bank bank = bankService.getBankAccount(accountNo);
		ModelAndView model = new ModelAndView("BankAccountForm");
		model.addObject("bank", bank);
		return model;
	}

	@RequestMapping(value = "/DepositAmount", method = RequestMethod.GET)
	public ModelAndView DepositAmount(HttpServletRequest request)
	{
		int accountNo = Integer.parseInt(request.getParameter("account_No"));
		Bank bank = bankService.getBankAccount(accountNo);
		ModelAndView model = new ModelAndView("DepositForm");
		model.addObject("bank",bank);
		return model;
	}

	@RequestMapping(value = "/saveDepositAmount", method = RequestMethod.POST)
	public ModelAndView saveDepositAmount(@ModelAttribute("bank") Bank bank) {

		int id=bank.getAccount_No();
		System.out.println("deposit id "+id);
		int availableBalance=bank.getBalance();
		System.out.println("deposit Abalance "+availableBalance);
		int deposit= bank.getDeposit_amount();
		System.out.println("deposit "+deposit);
		
		bank.setBalance(availableBalance + deposit);
		bankService.UpdateCreditAmount(bank);


		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/WithdrawalAmount", method = RequestMethod.GET)
	public ModelAndView WithdrawalAmount(HttpServletRequest request)
	{
		int accountNo = Integer.parseInt(request.getParameter("account_No"));
		Bank bank = bankService.getBankAccount(accountNo);
		ModelAndView model = new ModelAndView("WithdrawalForm");
		model.addObject("bank",bank);
		return model;
	}

	@RequestMapping(value = "/saveWithdrawalAmount", method = RequestMethod.POST)
	public ModelAndView saveWithdrawalAmount(@ModelAttribute("bank") Bank bank) {

		int id=bank.getAccount_No();
		System.out.println("withdrawal id "+id);
		int availableBalance=bank.getBalance();
		System.out.println("withdrawal Abalance "+availableBalance);
		int withdrawal= bank.getWidrawl_amount();
		System.out.println("withdrawal "+withdrawal);
		
		bank.setBalance(availableBalance - withdrawal);
		bankService.UpdateWithdrawalAmount(bank);


		return new ModelAndView("redirect:/");
	}

}
