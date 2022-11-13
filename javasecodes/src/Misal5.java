
public class Misal5 {
	public static void main(String[] args) {
		double a = 2;
		double b = 6;
		double c = 3;
		double d = b * b - 4 * a * c;
		System.out.println(d);
		double x1 = (-b + Math.sqrt(d)) / (2 * a);
		double x2 = (-b - Math.sqrt(d)) / (2 * a);
		System.out.println(x1);
		System.out.println(x2);
	}
}
