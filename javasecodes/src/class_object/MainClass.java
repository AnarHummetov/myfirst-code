package class_object;

public class MainClass {

	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book();

		b1.id = 2313994;
		b1.name = "Dan Ulduzu";
		b1.author = "Elcin Ezimli";
		b1.pageCount = 354;

		b2.id = 3245687;
		b2.name = "Qara Pantera";
		b2.author = "Elxan Elatli";
		b2.pageCount = 452;
		
		System.out.println(b1.id);
		System.out.println(b1.name);
		System.out.println(b1.author);
		System.out.println(b1.pageCount);
	
	
		System.out.println(b2.id);
		System.out.println(b2.name);
		System.out.println(b2.author);
		System.out.println(b2.pageCount);
	}
	
	

}
