package ders7;

public class ClassandObjectAndConstructors {

	public static void main(String[] args) {

		Computer comp1 = new Computer();
		Computer comp2 = new Computer("Lenovo");
		Computer comp3 = new Computer("Acer ", "Black");
		
		comp1=comp2;
		System.out.println(comp1.model);
		
		System.out.println(comp2.model);
		System.out.println(comp3.model);
		System.out.println(comp3.color);
	}
}
