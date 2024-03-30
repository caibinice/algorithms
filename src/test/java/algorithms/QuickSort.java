package algorithms;

public class QuickSort {

    //实现快速排序
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        backTrack(arr, 0, arr.length - 1);
    }

    private static void backTrack(int[] arr, int left, int right) {
        if (left >= right) return;
        //将数组最左端元素设为基准位
        int temp = arr[left];
        int i = left, j = right;
        while (i != j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        backTrack(arr, left, i - 1);
        backTrack(arr, i + 1, right);
    }

    public static void main(String[] args) {
        //测试用例
        int[] arr = {3,9,1,2,5,7,4,8,6};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
