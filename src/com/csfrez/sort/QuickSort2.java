package com.csfrez.sort;

import java.util.Arrays;

public class QuickSort2 {

	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		// 递归结束条件：startIndex大等于endIndex的时候
		if (startIndex >= endIndex) {
			return;
		}
		// 得到基准元素位置
		int pivotIndex = partition(arr, startIndex, endIndex);
		// 根据基准元素，分成两部分递归排序
		quickSort(arr, startIndex, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, endIndex);
	}

	
	/**
	 * 分治（双边循环法）
	 * @param arr 待交换的数组
	 * @param startIndex 起始下标
	 * @param endIndex 结束下标
	 * @return
	 */
	private	static int partition(int[] arr, int startIndex, int endIndex) {
		// 取第一个位置的元素作为基准元素
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		while (left != right) {
			// 控制right指针比较并左移
			while (left < right && arr[right] > pivot) {
				right--;
			}
			// 控制left指针比较并右移
			while (left < right && arr[left] <= pivot) {
				left++;
			}
			// 交换left和right指向的元素
			if (left < right) {
				int p = arr[left];
				arr[left] = arr[right];
				arr[right] = p;
			}
			System.out.println("left="+left+", lenth="+arr.length+", array="+Arrays.toString(arr));
		}

		// pivot和指针重合点交换
		int p = arr[left];
		arr[left] = arr[startIndex];
		arr[startIndex] = p;
		return left;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 4, 6, 5, 3, 2, 8, 1 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
