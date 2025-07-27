package greedy;

import java.util.Arrays;

// infinite supply of coins if some one asks for an amount we have to give the amount using mun coins

class Activity{
	int start;
	int end;
	public Activity(int start,int end) {
		this.start=start;
		this.end = end;
		// TODO Auto-generated constructor stub
	}
}

class Item{
	int value;int weight;
	public Item(int value,int weight) {
		this.value=value;
		this.weight=weight;
		// TODO Auto-generated constructor stub
	}
}

class Job{
	int id;int deadline;int profit;
	Job(int id,int deadline,int profit){
		this.id=id;
		this.deadline=deadline;
		this.profit=profit;
	}
}
public class CoinProblem {
	
	public static void main(String[] args) {
		int [] coins = {2,1,5,10};int amount =52;
//		System.out.println(getMinCoins(coins,amount));
		
//		Activity arr[] = {new Activity(12, 25),new Activity(10, 20),new Activity(20, 30)};
//		System.out.println(getMaxActivity(arr));
//		 Item[] items = {
//		            new Item(60, 10),
//		            new Item(100, 20),
//		            new Item(120, 30)
//		        };
//
//		        int capacity = 50;
//		System.out.println(getFractionalValue(items,capacity));
		Job[] jobs= {
				  new Job(1, 4, 20),
		            new Job(2, 1, 10),
		            new Job(3, 1, 40),
		            new Job(4, 1, 30)
		};
		
		System.out.println(Arrays.toString(getMaxProfit(jobs)));
	}
	
	static int[] getMaxProfit(Job[] jobs) {
		Arrays.sort(jobs,(a,b)->b.profit-a.profit);
		
		// now make slot array
		int maxDeadLine =0;
		for(Job j : jobs) {
			maxDeadLine = Math.max(maxDeadLine, j.deadline);
		}
		
		int[] slots = new int[maxDeadLine+1];
		Arrays.fill(slots, -1);
		int countjobs =0; int totalProfit =0;
		for(Job j : jobs) {
			for(int i=j.deadline;i>0;i--) {
				if(slots[i] == -1) {
					slots[i] = j.id;
					countjobs++;
					totalProfit += j.profit;
					break;
					
				}
				
			}
		}
		
		 return new int[]{countjobs, totalProfit};
		
	}
	
	static int getFractionalValue(Item[] itm,int capacity) {
		Arrays.sort(itm,(a,b)->{
			double aR = (double)a.value/a.weight;
			double bR = (double) b.value/b.weight;
			return Double.compare(bR, aR);
			
		});
		
		double totalVal =0.0;
		for(Item it : itm) {
			if(capacity == 0) break;
			
			if(it.weight <= capacity) {
				capacity -=it.weight;
				totalVal +=it.value;
			}else {
				totalVal += it.value * (double)((capacity / it.weight));
				
			}
			
		}
		
		return (int)totalVal;
		
	}
	
	static int getMaxActivity(Activity [] arr) {
		Arrays.sort(arr, (a,b)->a.end - b.end);
//		Activity ans = arr[0];
		int count =1;
		int lastEnd = arr[0].end;
		for(int i=1;i<arr.length;i++) {
			if(arr[i].start >= lastEnd) {
				count++;
				lastEnd=arr[i].end;
			}
		}
		return count;
	}
	
	static int getMinCoins(int[] coins,int amount) {
		Arrays.sort(coins);
		int res = 0;
		for(int i=coins.length -1;i>=0;i--) {
			if(coins[i] <= amount) {
				int c =amount/coins[i];
				res = res + c;
				amount = amount - c*coins[i];
				if(amount ==0 ) {
					break;
				}
			}
		}
		
		return res;
	}

}
