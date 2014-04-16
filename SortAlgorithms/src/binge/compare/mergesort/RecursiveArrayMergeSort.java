package binge.compare.mergesort;

import java.util.Arrays;

public class RecursiveArrayMergeSort {
	/**
	 * Implementation of Merge Sort on Array
	 * @param arrays
	 */
	public static void mergeSort(int[] arrays, int leftIndex, int rightIndex){
		if(rightIndex - leftIndex + 1 < 2){
			return;
		}
		int middle = (rightIndex - leftIndex + 1)/2;
		mergeSort(arrays, leftIndex, leftIndex + middle -1);
		mergeSort(arrays, leftIndex + middle, rightIndex);
		merge(arrays, leftIndex, leftIndex+middle-1, leftIndex+middle, rightIndex);
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
		int[] arrays = {3, 5, 1, -3, 9, 100, 7, -12, 200};
		mergeSort(arrays, 0, arrays.length-1);
		printArrays(arrays);
	}

}
