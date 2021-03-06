package com.bl.birdsanctuarysystem;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Main main = new Main();
		main.showUserName();
	/*	Parrot parrot = new Parrot();
		parrot.id = "p001";
		Penguin penguin = new Penguin();
		penguin.id = "pn001";
		Ostrich ostrich = new Ostrich();
		ostrich.id = "o001";
		Duck duck = new Duck();
		duck.id = "d001";
		Penguin penguin2 = new Penguin();
		penguin2.id = "pn002";
		
		BirdSanctuaryRepository birdSanctuaryRepository = new BirdSanctuaryRepository();
		
		birdSanctuaryRepository.add(parrot);
		birdSanctuaryRepository.add(penguin);
		birdSanctuaryRepository.add(ostrich);
		birdSanctuaryRepository.add(duck);
		birdSanctuaryRepository.add(duck);
		birdSanctuaryRepository.add(penguin2);
		
		birdSanctuaryRepository.print();
		
		birdSanctuaryRepository.remove(parrot);
		birdSanctuaryRepository.remove(duck);
		
		System.out.println(" ");
		System.out.println("After Deleting");
		birdSanctuaryRepository.print();
	*/
		
		
	}
	
	public void showUserName() {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		final int EXIT_VALUE = 8;
		
		while(option != EXIT_VALUE) {
			
			System.out.println("Enter your options");
			System.out.println("\n1. Add Birds\n2. Remove Birds\n3. Print the birds"
					+ "\n4. Print Swimmable\n5. Print Flyable\n6. Print Eatable\n7. Edit Bird\n" 
			+ EXIT_VALUE + ". Exit");
			option = scanner.nextInt();
			
			ViewLayer viewLayer = new ViewLayer();
			
			switch(option) {
				case 1: 
					addTemporaryBirds();
					addBird();
					
//					Parrot parrot = new Parrot();
//					parrot.id = "p001";
//					Penguin penguin = new Penguin();
//					penguin.id = "pn001";
//					Ostrich ostrich = new Ostrich();
//					ostrich.id = "o001";
//					Duck duck = new Duck();
//					duck.id = "d001";
//					Penguin penguin2 = new Penguin();
//					penguin2.id = "pn002";
//					
//					BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
//					birdSanctuaryRepository.add(parrot);
//					birdSanctuaryRepository.add(penguin);
//					birdSanctuaryRepository.add(ostrich);
//					birdSanctuaryRepository.add(duck);
					
					
					break;
				case 2:
					System.out.println("Enter the bird name to remove");
					BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
					String birdName = scanner.nextLine();
					birdName = scanner.next();
					Bird removeBird = birdSanctuaryRepository.getBird(birdName);
					Bird bird2 = birdSanctuaryRepository.getBird(birdName);
					try {
						if(bird2 == null) {
							throw new BirdNotFoundException("Bird not found");
						}
						birdSanctuaryRepository.remove(removeBird);
						System.out.println("Removed bird");
					}catch(BirdNotFoundException e) {
						System.out.println("Exception occured");
					}
					break;
				case 3: 
					viewLayer.print();
					break;
				case 4:
					viewLayer.printSwimmable();
					break;
				case 5:
					viewLayer.printFlyable();
					break;
				case 6:
					viewLayer.printEatable();
					break;
				case 7:
					editBird();
					break;
			}
		}
	}
	
	private void addBird() {
		Scanner scanner = new Scanner(System.in);
		Bird bird = new Bird();
		System.out.println("Enter id:");
		bird.id = scanner.nextLine();;
		System.out.println("Enter name:");
		bird.name = scanner.nextLine();;
		System.out.println("Enter color:");
		int count = 1; 
		
		for(Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
			System.out.println(count+". "+color);
			count++;
		}
		
		int colorChoice = scanner.nextInt();
		
		int count1 = 1;
		for(Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
			if(colorChoice == count1) {
				bird.color = color;
				break;
			}
			count1++;
		}
		System.out.println("Can bird Fly?(enter true or false)");
		Boolean canFly = scanner.nextBoolean();
		bird.canFly = canFly;
		
		System.out.println("Can bird Swim?(enter true or false)");
		Boolean canSwim = scanner.nextBoolean();
		bird.canSwim = canSwim;
		
		BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
		birdSanctuaryRepository.add(bird);
		
	}

	private void addTemporaryBirds() {
		
		
		Bird duck = new Bird();
		duck.name = "Duck";
		duck.id = "d001";
		duck.color = Bird.Color.WHITE;
		duck.canFly = true;
		duck.canSwim = true;
		BirdSanctuaryRepository.getInstance().add(duck);
		
		Bird penguin = new Bird();
		penguin.name = "Penguin";
		penguin.id = "pn001";
		penguin.color = Bird.Color.BLACK_WHITE;
		penguin.canFly = false;
		penguin.canSwim = true;
		BirdSanctuaryRepository.getInstance().add(penguin);
		
		Bird parrot = new Bird();
		parrot.name = "Parrot";
		parrot.id = "p001";
		parrot.color = Bird.Color.GREEN;
		parrot.canFly = true;
		parrot.canSwim = false;
		BirdSanctuaryRepository.getInstance().add(parrot);
		
		Bird ostrich = new Bird();
		ostrich.name = "Ostrich";
		ostrich.id = "o001";
		ostrich.color = Bird.Color.GREY;
		ostrich.canFly = false;
		ostrich.canSwim = false;
		BirdSanctuaryRepository.getInstance().add(ostrich);
		
	}
	
	private void editBird() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the bird name to edit");
		String birdName = scanner.nextLine();
		
		Bird editBird = BirdSanctuaryRepository.getInstance().getBird(birdName);
		while(true) {
			System.out.println("1. Edit Bird Name\n2. Edit id\n3. Edit color\n4.Exit");
			int choice = scanner.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Enter new name");
					scanner.nextLine();
					String birdName1 = scanner.nextLine();
					editBird.name = birdName1; 
					break;
				case 2:
					System.out.println("Enter new id");
					scanner.nextLine();
					String bid = scanner.nextLine();
					editBird.id = bid;
					break;
				case 3:
					System.out.println("Enter new color");
					System.out.println("Choose the color");
					
					int count = 1; 
					
					for(Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
						System.out.println(count+". "+color);
						count++;
					}
					
					int colorChoice = scanner.nextInt();
					
					int count1 = 1;
					for(Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
						if(colorChoice == count1) {
							editBird.color = color;
							break;
						}
						count1++;
					}
					break;
				case 4: return;
			}
		}
	}
}
