package ders4.operatorlar;

public class Operatorlar {
	public static void main(String[] args) {
		int a = 28;
		int b = 14;
		int c = a + b;
		System.out.println(c);
		System.out.println("a*b=" + (a * b));

		/* CEVRENIN UZUNLUGU */
		double pi = 3.14D;
		int r = 17;
		double C = 2 * pi * r;
		System.out.println(C);

		// DAIRENIN SAHESI
		r = 2;
		double sahe = pi * r * r;
		System.out.println(sahe);

		int number = 37;
		number *= 3;
		System.out.println(number);
		System.out.println(number % 5);

		int i = 45;
		int s = i % 3;
		if (s == 0){
			System.out.println("qaliqsiz bolunur");

		} else {
			System.out.println("qaliq :" + s);

		}
	}
}
