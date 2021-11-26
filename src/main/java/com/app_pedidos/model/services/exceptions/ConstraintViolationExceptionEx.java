package com.app_pedidos.model.services.exceptions;

public class ConstraintViolationExceptionEx extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public ConstraintViolationExceptionEx(String msg) {
		super(msg);
	}
}
