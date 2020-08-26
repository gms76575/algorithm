package sort.heap;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        int[] input = new int[7];
        System.out.println("请输入排序前的数组:");
        Scanner scanner = new Scanner(System.in);
        for (int i=0;i<input.length;i++) {
            System.out.print(i+":");
            input[i] = scanner.nextInt();
        }
        System.out.println("输入完成，排序前的数组:"+ Arrays.toString(input));
        buildHeap(input);
        heapSort(input);
        System.out.println("完成排序"+Arrays.toString(input));
    }
    private static void buildHeap(int[] array) {
        for (int i=(array.length-2)/2;i>=0;i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println("二叉堆构建完成:"+ Arrays.toString(array));
    }
    private static void downAdjust(int[] array, int downIndex, int length) {
        int maxChildIndex = downIndex*2+1;
        int downValue = array[downIndex];
        while (maxChildIndex<length) {
            if (maxChildIndex+1<length&&array[maxChildIndex+1]>array[maxChildIndex]) {
                maxChildIndex++;
            }
            if (downValue>=array[maxChildIndex]) {
                break;
            }
            array[downIndex] = array[maxChildIndex];
            downIndex = maxChildIndex;
            maxChildIndex = downIndex*2+1;
        }
        array[downIndex] = downValue;
        System.out.println(Arrays.toString(array));
    }
    private static void heapSort(int[] array) {
        for (int i=array.length-1;i>0;i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array, 0, i);
        }
    }
}
