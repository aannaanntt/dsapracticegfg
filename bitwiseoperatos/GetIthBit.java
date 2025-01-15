package bitwiseoperatos;

public class GetIthBit {

	public static void main(String[] args) {
		System.out.println(getItheBit(67, 1));
		// set and reset ith bit yet to do
	}

	private static int getItheBit(int number, int i) {
		// TODO Auto-generated method stub
		return (number >> i) & 1;
	}

}
