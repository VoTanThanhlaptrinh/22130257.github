package lab2;

public class Task1_1 {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		int result;
		if (n == 0) {
			return 0;
		} else {
			result = (pow(-1, n + 1)) * n;
			return result += getSn1(--n);
		}

	}

	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int getSn2(int n) {
		int result = 1;
		if (n == 1) {
			return result;
		} else {
			result *= factorial(n);
			return result + getSn2(--n);
		}

	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		int result = 0;
		if (n == 0) {
			return result;
		} else {
			result = pow(n, 2);
			return result + getSn3(--n);
		}

	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	public static double getSn4(int n) {
		double result = 1;
		if (n == 0) {
			return result;
		} else {
			result = (pow(2, n) * factorial(n));

		}
		return 1 / result + getSn4(--n);
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(getSn1(n));
		System.out.println(getSn2(n));
		System.out.println(getSn3(n));
		System.out.println(getSn4(2));
	}

	public static int pow(int coSo, int soMu) {
		if (soMu == 0) {
			return 1;
		} else {
			return coSo *= pow(coSo, --soMu);
		}

	}

	public static int factorial(int n) {
		int result = 1;
		if (n == 1) {
			return result;
		} else {
			result = n;
			return result * factorial(--n);
		}

	}

}
