package sort.bucket;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class BucketSort {
    public static void main(String[] args) {
        double[] input = new double[7];
        System.out.println("请输入排序前的数组:");
        Scanner scanner = new Scanner(System.in);
        for (int i=0;i<input.length;i++) {
            System.out.print(i+":");
            input[i] = scanner.nextDouble();
        }
        System.out.println("输入完成，排序前的数组:"+ Arrays.toString(input));
        double[] sortedArray = bucketSort(input);
        System.out.println("完成排序"+Arrays.toString(sortedArray));
    }
    private static double[] bucketSort(double[] input) {
        double min = input[0], max = input[0];
        for (int i=1;i<input.length;i++) {
            if (input[i] < min) {
                min = input[i];
            } else if (input[i] > max) {
                max = input[i];
            }
        }
        double delta = max - min;
        LinkedList<Double>[] bucketArray = new LinkedList[input.length];
        for (int i=0;i<bucketArray.length;i++) {
            bucketArray[i] = new LinkedList<Double>();
        }
        for (int i=0;i<input.length;i++) {
            int bucketIndex = (int)((input[i]-min)*(input.length-1)/delta);
            bucketArray[bucketIndex].add(input[i]);
        }
        for (int i=0;i<bucketArray.length;i++) {
            Collections.sort(bucketArray[i]);
        }
        double[] sortedArray = new double[input.length];
        int index = 0;
        for (int i=0;i<bucketArray.length;i++) {
            for (double bucketItem : bucketArray[i]) {
                sortedArray[index++] = bucketItem;
            }
        }
        return sortedArray;
    }
}
