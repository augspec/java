package com.bkavca.pdf;

import java.io.Serializable;

public class SubjectDN implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cN;
	private String uId;
	private String l;
	private String s;
	private String c;
	
	public SubjectDN() {
		super();
	}

	public SubjectDN(String cN, String uId, String l, String s, String c) {
		super();
		this.cN = cN;
		this.uId = uId;
		this.l = l;
		this.s = s;
		this.c = c;
	}

	public String getcN() {
		return cN;
	}

	public void setcN(String cN) {
		this.cN = cN;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	
}
