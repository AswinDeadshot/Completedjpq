package com.ba.dao;

import javax.persistence.EntityManager;


import com.ba.pojo.Bank;

public class BankDAO {

	private EntityManager entityManager;
	
	
	public BankDAO() {
		entityManager = JPAUtil.getEntityManager();
	}

	
	public void addUserAccount(Bank bank) {
		
		entityManager.persist(bank);
	
	}
	
	
	public Bank getBalance(double accountNo) {
		Bank bank=entityManager.find(Bank.class, accountNo);
		return bank;
	}
	
	
	public Bank depositMoney(double accountNumber,long amount,String tran) {
		Bank bank=entityManager.find(Bank.class, accountNumber);
		bank.setBalance(bank.getBalance()+amount);
		bank.setTran(tran+bank.getTran());
		return bank;
	}
	
	
	public Bank withdrawMoney(double accountNumber, long amount,String tran) {
		Bank bank=entityManager.find(Bank.class, accountNumber);
		bank.setBalance(bank.getBalance()-amount);
		bank.setTran(tran+bank.getTran());
		return bank;
	}


	public String getTransaction(double accountNumber) {
		Bank bank=entityManager.find(Bank.class, accountNumber);
		String tran=bank.getTran();
		return tran;
	}
	
	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}


	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}


	public boolean checkAccNo(double accountNumber) {
		Bank bank=entityManager.find(Bank.class, accountNumber);
		if(bank==null)
		return false;
		else
			return true;
	}






	


}
