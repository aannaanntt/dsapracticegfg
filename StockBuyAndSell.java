package arrays;

public class StockBuyAndSell {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 3, 8, 12 };
		System.out.println(maxProfit(arr));
	}

	private static int maxProfit(int[] arr) {
		int max_profit = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				max_profit += arr[i] - arr[i - 1];
			}

		}

		return max_profit;
	}

}
