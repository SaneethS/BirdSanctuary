package com.bl.birdsanctuarysystem;

public class BirdNotFoundException extends Exception{
	String message;
	
	public BirdNotFoundException(String message) {
		this.message = message;
	}
}
