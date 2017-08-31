package com.bkav.bkavcoreca.database;

import java.util.Date;

public class BankTransaction {
	private int id;
	private Date dateTransaction;
	private String numberBeneficiary;
	private String numberMoney;
	private String typeTransaction;
	private String signedPath;
	
	public BankTransaction() {
		
	}
	
	public BankTransaction(int id, Date dateTransaction, String numberBeneficiary, String numberMoney,
			String typeTransaction, String signedPath) {
		this.id = id;
		this.dateTransaction = dateTransaction;
		this.numberBeneficiary = numberBeneficiary;
		this.numberMoney = numberMoney;
		this.typeTransaction = typeTransaction;
		this.signedPath = signedPath;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public String getNumberBeneficiary() {
		return numberBeneficiary;
	}
	public void setNumberBeneficiary(String numberBeneficiary) {
		this.numberBeneficiary = numberBeneficiary;
	}
	public String getNumberMoney() {
		return numberMoney;
	}
	public void setNumberMoney(String numberMoney) {
		this.numberMoney = numberMoney;
	}
	public String getTypeTransaction() {
		return typeTransaction;
	}
	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}
	public String getSignedPath() {
		return signedPath;
	}
	public void setSignedPath(String signedPath) {
		this.signedPath = signedPath;
	}	
	
	
}
