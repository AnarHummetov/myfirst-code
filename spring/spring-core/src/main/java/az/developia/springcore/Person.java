package az.developia.springcore;

import org.springframework.stereotype.Component;

@Component
public class Person {
	String name;
	int age;
	double salary;

	public Person() {
		name = "Anar";
		age = 22;
		salary = 800;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
}
