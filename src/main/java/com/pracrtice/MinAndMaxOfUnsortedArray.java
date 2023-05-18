package com.pracrtice;

import java.util.Scanner;

public class MinAndMaxOfUnsortedArray {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt(); // Reading the size of the array
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt(); // Reading the array elements
		}

		int max_val = arr[0]; // Initializing the maximum value to the first element
		int min_val = arr[0]; // Initializing the minimum value to the first element

		// Iterating through the array to find the maximum and minimum values
		for (int i = 1; i < n; i++) {
			if (arr[i] > max_val) {
				max_val = arr[i];
			} else if (arr[i] < min_val) {
				min_val = arr[i];
			}
		}

		System.out.println("Max value: " + max_val);
		System.out.println("Min value: " + min_val);

		input.close();
	}
}
