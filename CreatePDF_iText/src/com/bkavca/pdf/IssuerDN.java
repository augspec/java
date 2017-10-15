package com.bkavca.pdf;

import java.io.Serializable;

public class IssuerDN implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cN;
	private String o;
	private String l;
	private String c;
	
	public IssuerDN() {
		super();
	}

	public IssuerDN(String cN, String o, String l, String c) {
		super();
		this.cN = cN;
		this.o = o;
		this.l = l;
		this.c = c;
	}

	public String getcN() {
		return cN;
	}

	public void setcN(String cN) {
		this.cN = cN;
	}

	public String getO() {
		return o;
	}

	public void setO(String o) {
		this.o = o;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	
}
