package com.bl.birdsanctuarysystem;

public class Ostrich extends Bird {
	Ostrich(){
		color = Color.GREY;
		name = "Ostrich";
	}


	@Override
	public void eat() {
		System.out.println(name + " can eat.");
	}
}
