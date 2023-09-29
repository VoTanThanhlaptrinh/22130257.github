package lab2;

public class MoveTower {
	public static void moveTower(int disk, String source, String dest, String spare) {
		if (disk == 1) {
			System.out.println("move " + disk + " from " + source + " to " + dest);
		} else {

			moveTower(disk - 1, source, spare, dest);
			System.out.println("move " + disk + " from " + source + " to " + dest);
			moveTower(disk - 1, spare, dest, source);
		}

	}

	public static void main(String[] args) {
		moveTower(3, "A", "B", "C");
	}
}
