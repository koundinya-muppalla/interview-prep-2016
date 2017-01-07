package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Knapsack {
	
	private static class Item {
		int price;
		int weight;
		public Item(int price, int weight) {
			this.price = price;
			this.weight = weight;
		}
	}
	
	public static int maxPrice(int w, Item[] items) {
		return maxPriceEPI(w, items);
	}
	
	
	public static int maxPriceEPI(int w, Item[] items) {
		int[] dp = new int[w + 1];
		for(Item item : items) {
			for(int i = w; i >= item.weight; --i) {
				dp[i] = Math.max(dp[i], dp[i - item.weight] + item.price);
			}
		}
		
		return dp[w];	
	}
	public static int maxPriceDP(int w, Item[] items) {
		int[][] dp = new int[items.length + 1][w + 1];
		
		for(int i = 0; i <= items.length; i++) {
			for(int j = 0; j <= w; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (items[i-1].weight <= j) {
					dp[i][j] = Math.max(dp[i-1][j], items[i-1].price + dp[i-1][j - items[i-1].weight]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[items.length][w];
	}
	
	private static int maxPrice(int remainingWeight, Item[] items, int index) {
		if(index >= items.length) {
			return 0;
		}
		
		if(remainingWeight < items[index].weight) {
			return maxPrice(remainingWeight, items, index + 1);
		}
		int consider = items[index].price + maxPrice(remainingWeight - items[index].weight, items, index + 1);
		int noConsider = maxPrice(remainingWeight, items, index + 1);
		
		return Math.max(consider, noConsider);
	}
	
	public static void main(String[] args) {
		Item[] items = Arrays.asList(new Item(65,20), new Item(35,8), new Item(245,60), new Item(195,55), new Item(65,40), new Item(150,70), 
				new Item(275,85), new Item(155,25), new Item(120,30), new Item(320,65), new Item(75,75)
		, new Item(40,10), new Item(200,95), new Item(100,50), new Item(220,40), new Item(99,10)).toArray(new Item[0]);
		System.out.println(maxPrice(130, items));
	}

}
