package algorithms;

public class ReverseInt {
	private static int reverseInt(int i) {
		if (i < 10) {
			return i;
		}
		return Integer.parseInt(Integer.toString(i % 10) + reverseInt(i / 10));
	}

	public static void main(String[] args) {
		System.out.println(reverseInt(12312313));
	}

}
