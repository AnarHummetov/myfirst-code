package ders7;

public class Computer {
	int prize;
	String brand;
	String model;
	String color;

	public Computer() {
		System.out.println("Default constructor");

	}

	Computer(String model) {
		this.model = model;
		System.out.println(model);
	}

	Computer(String model, String color) {
		this.model = model;
		this.color = color;
		System.out.println(model + color);
	}

}
