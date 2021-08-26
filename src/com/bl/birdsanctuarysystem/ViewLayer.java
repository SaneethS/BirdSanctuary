package com.bl.birdsanctuarysystem;

public class ViewLayer {
	
	public void print() {
		BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
		for(Bird item: birdSanctuaryRepository.getAllBirds()) {
			System.out.println(item);
		}
	}
	
	public void printFlyable() {
		BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
		for(Bird item: birdSanctuaryRepository.getAllBirds()) {
			if(item.canFly) {
				item.fly();
			}
		}
	}
	
	public void printSwimmable() {
		BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
		for(Bird item: birdSanctuaryRepository.getAllBirds()) {
			if(item.canSwim) {
				item.swim();
			}
		}
	}
	
	public void printEatable() {
		BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
		for(Bird item: birdSanctuaryRepository.getAllBirds()) {
			item.eat();
		}
	}
}
