package sketchBook;

import processing.core.PApplet;

public class QuickSort {
	
	private PApplet parent;
	
	public QuickSort(PApplet p) {
		this.parent = p;
	}
	
	public PApplet getParent() {
		return parent;
	}

	public void setParent(PApplet parent) {
		this.parent = parent;
	}
	
	// partition the subarray a[lo .. hi] by returning an index j
    	// so that a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
    	public void quickSort(int[] arr, int start, int end) {
    		if (start >= end) {
    	    	return;
    		}
    		int index = partition(arr, start, end);

    		quickSort(arr, start, index - 1);
    		quickSort(arr, index + 1, end);
    	}

	public int partition(int[] arr, int start, int end) {
    		int pivotValue = arr[end];
    		int pivotIndex = start;
    		  
    		for (int i = start; i < end; i++) {
    			if (arr[i] < pivotValue) {
    				swap(arr, i, pivotIndex);
    		    		pivotIndex++;
    		 	}
    		}
    		swap(arr, pivotIndex, end);
    		return pivotIndex;
    	}
    
    	public void swap(int[] arr, int a, int b) {
    		int temp = arr[a];
    		arr[a] = arr[b];
    		arr[b] = temp;
    	}
}