package com.jeekite.common.exception;

public class JeekiteBootException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public JeekiteBootException(String message){
		super(message);
	}
	
	public JeekiteBootException(Throwable cause)
	{
		super(cause);
	}
	
	public JeekiteBootException(String message,Throwable cause)
	{
		super(message,cause);
	}
}