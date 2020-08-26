package sort.quick;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = new int[7];
        System.out.println("请输入排序前的数组:");
        Scanner scanner = new Scanner(System.in);
        for (int i=0;i<input.length;i++) {
            System.out.print(i+":");
            input[i] = scanner.nextInt();
        }
        System.out.println("输入完成，排序前的数组:"+ Arrays.toString(input));
//        recursiveQuickSort(input, 0, input.length-1);
        nonRecursiveQuickSort(input);
        System.out.println("完成排序"+Arrays.toString(input));
    }
    private static void recursiveQuickSort(int[] input,int start,int end) {
        if (start>=end && start>=input.length && end<0) {
            return;
        }
        System.out.println("开始递归快速排序");
        int pivotIndex = partition(input, start, end);
        recursiveQuickSort(input, start, pivotIndex-1);
        recursiveQuickSort(input, pivotIndex+1, end);
    }
    private static int partition(int[] input,int start,int end) {
        int pivot = input[start];
        int left = start,right=end;
        while (left!=right) {
            while (right>left&&input[right]>pivot) {
                right--;
            }
            while (left<right&&input[left]<=pivot) {
                left++;
            }
            if (left<right) {
                System.out.println("交换顺序：" + input[left] + "-" + input[right]);
                int temp = input[left];
                input[left] = input[right];
                input[right] = temp;
            }
        }
        if (start<left) {
            System.out.println("交换顺序：" + input[start] + "-" + input[left]);
            input[start] = input[left];
            input[left] = pivot;
        }
        return left;
    }
    private static void nonRecursiveQuickSort(int[] input) {
        System.out.println("开始非递归快速排序");
        Stack<Map<String,Integer>> stack = new Stack<>();
        stack.push(newMap(0, input.length-1));
        while (!stack.isEmpty()) {
            Map<String, Integer> map = stack.pop();
            int start = map.get("start");
            int end = map.get("end");
            int pivotIndex = partition(input, start, end);
            if (start<pivotIndex-1) {
                stack.push(newMap(start, pivotIndex - 1));
            }
            if (end<pivotIndex+1) {
                stack.push(newMap(pivotIndex + 1, end));
            }
        }
    }

    private static Map<String, Integer> newMap(int start,int end) {
        Map<String, Integer> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end);
        return map;
    }
}
