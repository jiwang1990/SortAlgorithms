package binge.compare.mergesort;

import java.util.Arrays;

public class NonRecursiveArrayMergeSort {

	/**
	 * Implementation of Merge Sort on Array
	 * @param arrays
	 */
	public static void mergeSort(int[] arrays){
		if(arrays.length < 2){
			return;
		}
		// step: length of merged list, its value doubled in each iteration
		int step = 1;
		
		// startL: start index of left-sub list
		// startR: start index of right-sub list
		int startL;
		int startR;
		
		// outer loop variable is length of merged list
		while(step < arrays.length) {
			startL = 0;
			startR = startL + step;
			while(startR + step < arrays.length) {
				merge(arrays, startL, startL+step-1, startR, startR+step-1);
				startL = startR + step;
				startR = startL + step;
			}
			merge(arrays, startL, startL+step-1, startR, arrays.length-1);
			step *= 2;
		}
	}
	/**
	 * Merge two sub-list
	 * @param array
	 * @param startL: start index of left-sub list
	 * @param endL : end index of left-sub list
	 * @param startR: start index of right-sub list
	 * @param endR: end index of right-sub list
	 */
	private static void merge(int[] array, int startL, int endL, int startR, int endR) {
		int[] leftArray = Arrays.copyOfRange(array, startL, endL+1);
		int[] rightArray = Arrays.copyOfRange(array, startR, endR+1);
		
		int index = startL;
		int i = 0;
		int j = 0;
		while(i < leftArray.length && j < rightArray.length) {
			if(leftArray[i] <= rightArray[j]) {
				array[index++] = leftArray[i++];
			}else{
				array[index++] = rightArray[j++];
			}
		}
		if(i < leftArray.length)
			System.arraycopy(leftArray, i, array, index, leftArray.length-i);
		else
			System.arraycopy(rightArray, j, array, index, rightArray.length-j);
	}
	
	public static void printArrays(int[] arrays) {
		for(int element: arrays) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrays = {3, 5, 1, -3, 9, 100, 7, -12};
		mergeSort(arrays);
		printArrays(arrays);
	}


}
