package lab1;

import java.util.Random;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int n) {
		super();
		this.n = n;
	}

	public char encryptChar(char c) {
		int x = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				x = i;
				break;
			}
		}
		if (n > 26) {
			Random random = new Random();
			n = random.nextInt(0, 26);
			System.out.println("The shift step is greater than 26, so I generated a random number. It is: "+ n);
		}
		if (x != -1) {
			return ALPHABET[(x + n) % 26];
		} else {
			return c;
		}
	}

	public String encrypt(String input) {
		char[] arrChar = input.toCharArray();
		StringBuilder result = new StringBuilder();
		for (char b : arrChar) {
			result.append(encryptChar(b));
		}

		return result.toString();
	}

	public char decryptChar(char c) {
		int x = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				x = i;
				break;
			}
		}
		if (x != -1) {
			return ALPHABET[(x - n + 26) % 26];
		} else {
			return c;
		}

	}

	public String decrypt(String input) {
		char[] arrChar = input.toCharArray();
		StringBuilder result = new StringBuilder();
		for (char b : arrChar) {
			result.append(decryptChar(b));
		}

		return result.toString();

	}

	public static void main(String[] args) {
		MyCaesar myCaesar = new MyCaesar(100);
		String str = "REAGNGDLF";
		String str1 = "Dai hoc Nong Lam Tp.HCM";
		System.out.println(myCaesar.encryptChar('L'));
		System.out.println(myCaesar.encrypt(str1));
		System.out.println(myCaesar.decryptChar(myCaesar.encryptChar('L')));
		System.out.println(myCaesar.decrypt(myCaesar.encrypt(str1)));
	}
}
