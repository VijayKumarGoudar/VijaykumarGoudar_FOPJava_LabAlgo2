package com.greatlearning.lab2.algo;

import java.util.Scanner;

class Problem1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter the size of transaction array");
		int size = sc.nextInt();
		int transactionArray[] = new int[size];

		System.out.println("enter the values of array");
		for (int i = 0; i < size; i++)
			transactionArray[i] = sc.nextInt();

		System.out.println("enter the total no of targets that needs to be achieved");
		int targets = sc.nextInt();

		while (targets > 0) {

			int target;
			int sum = 0;
			System.out.println("enter the value of target");
			target = sc.nextInt();

			for (int i = 0; i < size; i++) {
				sum += transactionArray[i];

				if (sum >= target) {
					System.out.printf("Target achieved after %d transactions\n", i + 1);
					break;
				}

				if (i == size - 1) {
					System.out.println("Given target is not achieved");
				}
			}
			--targets;
		}

		sc.close();
	}
}
