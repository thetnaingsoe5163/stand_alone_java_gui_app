package com.tns.exceptions;

public class PathIsNotAbsolute extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PathIsNotAbsolute() {
		super("File path must be absolute!");
	}
}
