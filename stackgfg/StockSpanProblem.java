package stackgfg;

import java.util.Stack;

/***
 * 
 * 
 * The Stock Span Problem is a classical problem in financial analysis that aims
 * to find the span of stock prices for each day. The span is defined as the
 * number of consecutive days (including the current day) for which the price of
 * a stock is less than or equal to its price on the current day.
 * 
 */
public class StockSpanProblem {

	public static void main(String[] args) {
		int[] arr = { 13, 15, 12, 14, 16, 8, 6, 4, 10, 30 };

		printStockSpanStack(arr);
	}

	private static void printStockSpanStack(int[] prices) {
		Stack<Integer> st = new Stack<>();
		int n = prices.length;
		int span = 0;
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
				st.pop();
			}
			span = st.isEmpty() ? i + 1 : i - st.peek();
			System.out.print(span + " ");
			st.push(i);
		}

	}

	private static void printStockSpanNaive(int[] prices) {
		int n = prices.length;
		for (int i = 0; i < n; i++) {
			int span = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (prices[j] <= prices[i]) {
					span++;
				}
			}

			System.out.print(span + " ");

		}

	}

}
