package com.bkav.bkavcoreca.pdf;

import java.util.Date;

public class BankReceipt {
	
	public BankReceipt() {
		
	}
	
	String accountNumberOriginal;
	String accountNumberBeneficiary;
	String nameBeneficiary;
	String nameBankBeneficiary;
	String nameBranchBankBeneficiary;
	String numberMoney;
	String costBearer;
	String description;
	String codeOTP;
	Date dateTransaction;
	
	String subjectDN;
	String serialNumber;
	String certDate;
	
	String signature;

	public String getAccountNumberOriginal() {
		return accountNumberOriginal;
	}

	public void setAccountNumberOriginal(String accountNumberOriginal) {
		this.accountNumberOriginal = accountNumberOriginal;
	}

	public String getAccountNumberBeneficiary() {
		return accountNumberBeneficiary;
	}

	public void setAccountNumberBeneficiary(String accountNumberBeneficiary) {
		this.accountNumberBeneficiary = accountNumberBeneficiary;
	}

	public String getNameBeneficiary() {
		return nameBeneficiary;
	}

	public void setNameBeneficiary(String nameBeneficiary) {
		this.nameBeneficiary = nameBeneficiary;
	}

	public String getNameBankBeneficiary() {
		return nameBankBeneficiary;
	}

	public void setNameBankBeneficiary(String nameBankBeneficiary) {
		this.nameBankBeneficiary = nameBankBeneficiary;
	}

	public String getNameBranchBankBeneficiary() {
		return nameBranchBankBeneficiary;
	}

	public void setNameBranchBankBeneficiary(String nameBranchBankBeneficiary) {
		this.nameBranchBankBeneficiary = nameBranchBankBeneficiary;
	}

	public String getNumberMoney() {
		return numberMoney;
	}

	public void setNumberMoney(String numberMoney) {
		this.numberMoney = numberMoney;
	}

	public String getCostBearer() {
		return costBearer;
	}

	public void setCostBearer(String costBearer) {
		this.costBearer = costBearer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCodeOTP() {
		return codeOTP;
	}

	public void setCodeOTP(String codeOTP) {
		this.codeOTP = codeOTP;
	}


	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public String getSubjectDN() {
		return subjectDN;
	}

	public void setSubjectDN(String subjectDN) {
		this.subjectDN = subjectDN;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCertDate() {
		return certDate;
	}

	public void setCertDate(String certDate) {
		this.certDate = certDate;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
