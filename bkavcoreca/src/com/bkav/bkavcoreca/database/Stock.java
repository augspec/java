package com.bkav.bkavcoreca.database;

import java.io.Serializable;
import java.util.Date;

/**
 * Đại diện cho bảng stock trong DB
 * 
 * @author HungDMc
 *
 */
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	private long stockId;
	private String type;
	private String name;
	private int amounts;
	private String commandType;
	private double price;
	private String market;
	private String clientDataSigned;
	private String serverDataSigned;
	private Date transactionTime;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(long stockId, String type, String name, int amounts,
			String commandType, double price, String market,
			String clientDataSigned, String serverDataSigned,
			Date transactionTime) {
		super();
		this.stockId = stockId;
		this.type = type;
		this.name = name;
		this.amounts = amounts;
		this.commandType = commandType;
		this.price = price;
		this.market = market;
		this.clientDataSigned = clientDataSigned;
		this.serverDataSigned = serverDataSigned;
		this.transactionTime = transactionTime;
	}

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmounts() {
		return amounts;
	}

	public void setAmounts(int amounts) {
		this.amounts = amounts;
	}

	public String getCommandType() {
		return commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getClientDataSigned() {
		return clientDataSigned;
	}

	public void setClientDataSigned(String clientDataSigned) {
		this.clientDataSigned = clientDataSigned;
	}

	public String getServerDataSigned() {
		return serverDataSigned;
	}

	public void setServerDataSigned(String serverDataSigned) {
		this.serverDataSigned = serverDataSigned;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	
}
