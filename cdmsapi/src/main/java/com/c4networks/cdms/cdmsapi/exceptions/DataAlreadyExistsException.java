package com.c4networks.cdms.cdmsapi.exceptions;

public class DataAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataAlreadyExistsException() {
		super();
	}

	public String toString() {
		return "Data Already exists at CDMS";
	}

}
