
public class PrimitiveTypeConversionHome {
	public static void main(String[] args) {
		int a = 55;
		byte b = (byte) a;
		System.out.println(b);
		short c = 363;
		byte d = (byte) c; // 107 burda "overflow" bas verir
		System.out.println(d);
		long aa = 435;
		short ab = (short) aa;
		System.out.println(ab);
		long bb = 4536729;
		int bc = (int) bb;
		System.out.println(bc);
		double e = 373.56D;
		int e1 = (int) e;
		System.out.println(e1);
		char simvol='A';
		int kodu=(int)simvol;
		System.out.println(kodu);
		int f=78;
		char h=(char)f;
		System.out.println(h);
	}

}
