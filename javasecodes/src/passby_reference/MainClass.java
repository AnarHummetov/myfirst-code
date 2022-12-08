package passby_reference;

public class MainClass {

	public static void main(String[] args) {
	Person p1=new Person("Sahil", "Kerimov", 2, "094-711");

	SalaryCalculator c1=new SalaryCalculator();
	c1.calculateSalary(p1);
	
	p1.printInfo();
	}

}
