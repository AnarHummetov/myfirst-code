package ders11.evisi;

import java.util.Arrays;

public class Ders11MassivlerEv {
	public static void main(String[] args) {

		int[] numbers = new int[5];
		numbers[0] = 5;
		numbers[1] = 7;
		numbers[2] = 4;
		numbers[3] = 11;
		numbers[4] = 8;
		// Deyerlerin cemini tapmaq

		int cem = 0;
		for (int i : numbers) {
			cem += i;
		}
		System.out.println("Deyerlerin cemi: " + cem);

		// Deyerlerin ededi ortasini tapmaq

		int edediOrta = cem / numbers.length;
		System.out.println("Ededi ortasi: " + edediOrta);

		// En boyuk ve en kicik deyeri tapmaq

		Arrays.sort(numbers);
		System.out.println("En kicik deyer: " + numbers[0]);
		System.out.println("En boyuk deyer: " + numbers[4]);

		// massivin elementlərindən tək olanları tapmaq

		System.out.println("Tek olan deyerler");

		for (int i : numbers) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}

		// massivin elementlərindən cüt olanları tap

		System.out.println("Cut olan deyerler");

		for (int i : numbers) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		// massivin elementlərindən sadə ədəd olanları tap

		System.out.println("sade ededler");

		for (int i : numbers) {

			for (int j = 2; j < i - 1; j++) {
				if (i % j != 0) {
					System.out.println(i);
				}break;
			}
		}
	}
}
