package arrays;

public class LeadersInArray {

	public static void main(String[] args) {
		int[] arr = { 7, 10, 4, 3, 6, 5, 2 };
		leaderInArray2(arr);
	}
	
	//efficient 
	public static void leaderInArray2(int arr[]) {
		int cur_leader = arr[arr.length-1];
		System.out.println(cur_leader);
		for(int i = arr.length -2 ;i>=0;i--) {
			if(cur_leader<arr[i]) {
				cur_leader=arr[i];
				System.out.println(cur_leader);
			}
		}
		
	}
	//not efficient
	private static void leaderInArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			boolean isLeader = false;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= arr[i]) {
					isLeader = true;
					break;
				}
			}

			if (!isLeader) {
				System.out.println(arr[i] + " ");
			}
		}
	}
}
