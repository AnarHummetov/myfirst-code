package az.developia.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);

		Book book=context.getBean(Book.class);
		System.out.println(book);
		
		Person person=context.getBean(Person.class);
		System.out.println(person);
		
		String[] beanNames= context.getBeanDefinitionNames();
		System.out.println(beanNames);
		}

}
