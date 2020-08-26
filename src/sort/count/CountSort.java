package sort.count;

import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        int[] input = new int[7];
        System.out.println("请输入排序前的数组:");
        Scanner scanner = new Scanner(System.in);
        for (int i=0;i<input.length;i++) {
            System.out.print(i+":");
            input[i] = scanner.nextInt();
        }
        System.out.println("输入完成，排序前的数组:"+ Arrays.toString(input));
        int[] sortedArray = countSort(input);
        System.out.println("完成排序"+Arrays.toString(sortedArray));
    }
    private static int[] countSort(int[] input) {
        int min = input[0], max = input[0];
        for (int i=1;i<input.length;i++) {
            if (input[i] < min) {
                min = input[i];
            } else if (input[i] > max) {
                max = input[i];
            }
        }
        int[] countArray = new int[max-min+1];
        for (int value : input) {
            countArray[value-min]++;
        }
        //变形
        for (int i=1;i<countArray.length;i++) {
            countArray[i]+=countArray[i-1];
        }
        int[] sortedArray = new int[input.length];
        for (int value : input) {
            sortedArray[countArray[value - min]-1] = value;
            countArray[value - min]--;
        }
        return sortedArray;
    }
}
