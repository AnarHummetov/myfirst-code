package passby_reference;

public class Person {
	String name;
	String surname;
	int experienceYear;
	int salary;
	String phone;

	public Person(String name, String surname, int experienceYear, String phone) {
		this.name = name;
		this.surname = surname;
		this.experienceYear = experienceYear;
		this.phone = phone;
	}

	void printInfo() {
		System.out.println("Ad = " + name);
		System.out.println("Soyad = " + surname);
		System.out.println("Is tecrubesi = " + experienceYear + " il");
		System.out.println("Maas = " + salary+" azn");
		System.out.println("Telefon = " + phone);
	}

}
