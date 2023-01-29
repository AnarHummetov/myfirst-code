package az.developia.springcore;

import org.springframework.stereotype.Component;

@Component
public class Book {
	int id;
	String name;
	double price;
	int pageCount;

	public Book() {
		name = "Victor Hugo";
		price = 45;
		pageCount = 456;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", pageCount=" + pageCount + "]";
	}

}
