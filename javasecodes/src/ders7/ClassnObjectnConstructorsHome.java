package ders7;

public class ClassnObjectnConstructorsHome {
	public static void main(String[] args) {

		Employee emp1=new Employee();
		Employee emp2=new Employee("Sahil");
		Employee emp3=new Employee("Sayid","Mamedov");
		Employee emp4=new Employee("Elvin", 35, 1300);
		
		System.out.println(emp2.name);
		System.out.println(emp3.surname);
		System.out.println(emp4.age);
		emp1=emp4;
		System.out.println(emp1.salary);
	}
}
