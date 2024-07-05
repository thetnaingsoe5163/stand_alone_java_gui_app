package com.tns.exceptions;

public class TargetDirNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TargetDirNotFoundException() {
		super("Your folder doesn't exist!\nPlease! enter existing folder");
	}
}
