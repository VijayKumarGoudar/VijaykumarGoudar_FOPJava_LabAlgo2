package com.greatlearning.lab2.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem2 {

	public static Map<Integer, Integer> a = new HashMap<Integer, Integer>(); // a is used for backtracking coins used

	public static int fun(int[] denominations, int amount, Map<Integer, Integer> m) {
		
		if (amount == 0) {
			return 0;
		}

		if (m.containsKey(amount)) {
			return m.get(amount);
		}

		int min = (int) Math.pow(2, 31) - 1;
		int val = 0;
		
		for (int i = 0; i < denominations.length; i++) {

			if (denominations[i] > amount) {
				continue;
			}

			int temp = fun(denominations, amount - denominations[i], m);

			if (temp < min) {
				min = temp;
				val = amount - denominations[i];
			}
		}

		a.put(amount, val); // store by using which coin value minimum coins for amount is found

		if (min != ((int) Math.pow(2, 31) - 1)) {
			min++;
		}
		return min;
	}

	public static void main(String[] args) {

		// Problem can be solved using recursion and memoization

		Scanner sc = new Scanner(System.in);

		System.out.println("enter the size of currency denominations ");
		int n = sc.nextInt();
		int[] denominations = new int[n];

		System.out.println("enter the currency denominations value ");
		for (int i = 0; i < n; i++) {
			denominations[i] = sc.nextInt();
		}

		System.out.println("enter the amount you want to pay ");
		int amount = sc.nextInt();

		// map to store minimum coins required for each total intermediate amount
		Map<Integer, Integer> m = new HashMap<>();

		// call recursive function to get minimum number of coins required
		int minNoCoins = fun(denominations, amount, m);
		System.out.println("Minimum number of coins: " + minNoCoins);

		boolean flag = true;
		int tempAmount = amount;

		Map<Integer, Integer> coinCount = new TreeMap<Integer, Integer>();
		while (flag) {

			int temp = a.get(tempAmount);
			int v = tempAmount - temp;
			tempAmount = temp;

			if (coinCount.containsKey(v)) {
				int k = coinCount.get(v);
				coinCount.put(v, k + 1);
			} else {
				coinCount.put(v, 1);
			}

			if (temp == 0)
				flag = false;
		}

		System.out.println("Your payment approach in order to give min no of notes will be");
		for (Map.Entry<Integer, Integer> entry : coinCount.entrySet()) {
			System.out.println("coin: " + entry.getKey() + ", count: " + entry.getValue());
		}

		sc.close();
	}

}
