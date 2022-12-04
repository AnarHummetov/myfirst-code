package der8.metodlar;

public class Methods {

	void printName(int count, String name) {
		for (int i = 0; i < count; i++) {
			System.out.println(name);
		}
	}

	public static void main(String[] args) {
		Methods a1=new Methods();
		a1.printName(4, "Asif");
		a1.printName(7, "Salam");
		a1.printName(5, "Alim");
	}
	
	}


