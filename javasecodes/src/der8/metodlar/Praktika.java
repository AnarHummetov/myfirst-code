package der8.metodlar;

public class Praktika {
	public static void main(String[] args) {
		int telebe1Bali = 78;
		int telebe2Bali = 91;
		int telebe3Bali = 55;

		char telebe1Xali = qiymetVer(telebe1Bali);
		char telebe2Xali = qiymetVer(telebe2Bali);
		char telebe3Xali = qiymetVer(telebe3Bali);
		
		System.out.println("telebe1Xali = " + telebe1Xali);
		System.out.println("telebe2Xali = " + telebe2Xali);
		System.out.println("telebe3Xali = " + telebe3Xali);
	}

	static char qiymetVer(int bal) {
		char kateqoriya = 'A';
		if (bal > 90) {
			kateqoriya = 'A';
		} else if (bal > 80) {
			kateqoriya = 'B';
		} else if (bal > 70) {
			kateqoriya = 'C';
		} else if (bal > 60) {
			kateqoriya = 'D';
		} else if (bal > 50) {
			kateqoriya = 'E';
		} else {
			kateqoriya = 'F';
		}
		return kateqoriya;
	}
}
