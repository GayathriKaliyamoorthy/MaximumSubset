package com.hackathon.MaximumSubsetSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author GayathriK
 *
 * Recurrence for the problem:
 * For an array elem[] maximum subSetSum can be calculated using
 * this recurrence
 *  Sum[i, elem] = max(Sum[i-2]+elem[i], Sum[i-1]) 
 *  Implemented this recurrence with Memoization.
 */
public class MaximumSubsetSum {
	public static int subSetSumArr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arrStr;  
		arrStr = br.readLine();
		String[] items = arrStr.split(" ");
		int[] arr = new int[items.length];
		subSetSumArr = new int[items.length];
		for (int i = 0; i < items.length; i++) {
		        arr[i] = Integer.parseInt(items[i]);
		}
		int maxSum = getMaximumSum(arr);
		System.out.println("MaximumSum = " + Integer.toString(maxSum));
	}
	
	// calculates the maximum subset of an array such that elements
	// are not contiguous
	public static int getMaximumSum(int[] arr) {
		int length = arr.length;
		int maximumSum = arr[0];
		for (int i = 0; i < length; i++){
			int sum = subSetSum(arr, i);
			// In case of negative numbers, Sum can reduce the 
			// total value of the element we are currently processing.
			if (maximumSum < sum && sum > arr[i]) {
				maximumSum = sum;
			}
			else if(arr[i] > maximumSum){
				maximumSum = arr[i];
			}
		}
		return maximumSum;
	}
	
	// returns a subset sum for arr from 0..index
	public static int subSetSum(int[] arr, int index) {
		if (index == 0 || index == 1){
			subSetSumArr[index] = arr[index];
			return arr[index];
		}
		else{
			if(subSetSumArr[index] != 0) {
				return subSetSumArr[index];
			}
			else{
			 subSetSumArr[index] = subSetSum(arr, index-2) + arr[index];
			 return subSetSumArr[index];
			}
		}
	}
}
