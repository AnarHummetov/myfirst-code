
package ders11.massivler;

public class Ders11Massivler2 {
	public static void main(String[] args) {
		int[] massiv = new int[5];
		massiv[0] = 5;
		massiv[1] = 6;
		massiv[2] = 4;
		massiv[3] = 1;
		massiv[4] = 9;
		int say = massiv.length;
		int cem = 0;
		for (int i = 0; i < say; i++) {
			cem = cem + massiv[i];
		}
		System.out.println(cem);
	}
}
