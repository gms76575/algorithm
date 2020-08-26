package search.insertion;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSearch {
    public static void main(String[] args) {
        int[] array = new int[]{1,6,7,11,19,21,38,39,43,45,46,59,60,66,72,75,80,88,92,99};
        System.out.println("有序数组:"+Arrays.toString(array));
        System.out.println("请输入要查找的数字:");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int searchResult = binarySearch(array, input, 0, array.length-1);
        if (searchResult < 0) {
            System.out.println("在数组中没有找到数字"+input);
        } else {
            System.out.println(input+"在数组中的位置是"+searchResult);
        }
    }
    private static int binarySearch(int[] array, int searchNum, int minIndex, int maxIndex) {
        if (searchNum < array[minIndex] || searchNum>array[maxIndex]) {
            return -1;
        }
        System.out.println("查找下标范围："+minIndex+"-"+maxIndex);
        int mid = minIndex+(searchNum-array[minIndex])*(maxIndex-minIndex)/(array[maxIndex]+array[minIndex]);
        System.out.println("查找下标："+mid);
        if (array[mid] == searchNum) {
            System.out.println("找到了!");
            return mid;
        } else if (array[mid] < searchNum) {
            System.out.println("找到"+array[mid]+",小了!");
            return binarySearch(array, searchNum, mid+1, maxIndex);
        } else {
            System.out.println("找到"+array[mid]+",大了!");
            return binarySearch(array, searchNum, minIndex, mid-1);
        }
    }
}
