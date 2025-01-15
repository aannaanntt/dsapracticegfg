package binarysearchgfg;

public class SquareRoot {

	public static void main(String[] args) {
		int x = 5;
		System.out.println(getSquareRootPrecise(50, 5));
	}

	public static double getSquareRootPrecise(double x, int precision) {
		if (x < 0)
			return -1;
		double start = 0;
		double end = x;
		double mid = 0;
		if (x < 1)
			end = 1;

		while ((end - start) >= 1e-9) {
			mid = start + (end - start) / 2;
			if (mid * mid == x) {
				return mid;
			} else if (mid * mid < x) {
				start = mid;
			} else {
				end = mid;
			}
		}
		


		// refine the result
		double increment = 0.1;
		for (int i = 0; i < precision; i++) {
			while (mid * mid <= x) {
				mid += increment;
			}
			mid -= increment;
			increment /= 10;
		}

		return Math.round(mid * Math.pow(10, precision)) / Math.pow(10, precision);

	}

	public static int getSquareRootBS(int x) {
		int start = 0;
		int end = x;
		while (start <= end) {
			int mid = start + (end - start);
			int val = mid * mid;
			if (val > x) {
				end = mid - 1;
			} else if (val < x) {
				start = mid + 1;
			}

		}

		return end;

	}

	private static int getSquareRoot(int x) {
		int i = 0;
		while (i * i <= x) {
			i++;
		}
		return i - 1;
	}

}
