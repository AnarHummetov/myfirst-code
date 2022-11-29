package ders7;

public class MainClass {
	public static void main(String[] args) {

		Person Adil = new Person();// arqument
		Person Asif = new Person();
		Person Ilhame = new Person();

		Adil.yas = 24;
		Adil.soyad = "Eliyev";

		Asif.soyad = "Haciyev";
		Asif.yas = 23;

		Ilhame.yas = 48;
		Ilhame.soyad = "Hummetova";
		
		System.out.println(Ilhame.yas);
	}
}
