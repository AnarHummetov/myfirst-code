package ders7;

public class Employee {

	String name;
	String surname;
	int age;
	String address;
	int salary;

	Employee() {
		System.out.println("Default constructor");
	}

	Employee(String name) {
		this.name = name;

	}

	Employee(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	Employee(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
}
