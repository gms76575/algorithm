package sort.bubble;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input = new int[7];
        System.out.println("请输入排序前的数组:");
        Scanner scanner = new Scanner(System.in);
        for (int i=0;i<input.length;i++) {
            System.out.print(i+":");
            input[i] = scanner.nextInt();
        }
        System.out.println("输入完成，排序前的数组:"+Arrays.toString(input));
        betterBubbleSort(input);
//        simpleBubbleSort(input);
        System.out.println("完成排序"+Arrays.toString(input));
    }
    private static void simpleBubbleSort(int[] input) {
        System.out.println("开始简单冒泡排序");
        for (int i=0;i<input.length-1;i++) {
            System.out.println("轮数："+(i+1));
            boolean isSort = true;
            for (int j=0;j<input.length-1-i;j++) {
                if (input[j]>input[j+1]) {
                    System.out.println("交换顺序："+input[j]+"-"+input[j+1]);
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    isSort = false;
                    System.out.println(Arrays.toString(input));
                }
                System.out.println(Arrays.toString(input));
            }
            if (isSort) {
                break;
            }
        }
    }
    private static void betterBubbleSort(int[] input) {
        System.out.println("开始双向冒泡排序");
        for (int i=0;i<input.length/2;i++) {
            System.out.println("轮数："+i);
            boolean isSort = true;
            for (int j=i;j<input.length-1-i;j++) {
                if (input[j]>input[j+1]) {
                    System.out.println("交换顺序："+input[j]+"-"+input[j+1]);
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    isSort = false;
                    System.out.println(Arrays.toString(input));
                }
            }
            if (isSort) {
                break;
            }
            isSort = true;
            for (int j=input.length-2-i;j>i;j--) {
                if (input[j]<input[j-1]) {
                    System.out.println("交换顺序："+input[j-1]+"-"+input[j]);
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                    isSort = false;
                    System.out.println(Arrays.toString(input));
                }
            }
            if (isSort) {
                break;
            }
        }
    }
}
