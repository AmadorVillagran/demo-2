package com.example.demo.exception;

public class DemoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codError;

	public DemoException() {
	}

	public DemoException(String cod, String msg) {
		super(msg);
		this.codError = cod;
	}

	public DemoException(String msg) {
		super(msg);
	}

	public String getCodError() {
		return codError;
	}

	public void setCodError(String codError) {
		this.codError = codError;
	}
}
