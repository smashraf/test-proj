package rohan.ds;

public class DpQue {

    public int getMaxSubArray(Integer[] arr) {
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] + temp[i - 1] > arr[i]) {
                temp[i] = arr[i] + temp[i - 1];
            } else {
                temp[i] = arr[i];
            }
        }
        int max = temp[0];
        for (int i : temp) {
            if (i > max)
                max = i;
        }
        return max;
    }

    public int kadane(Integer[] arr) {
        int globalMax = arr[0];
        int runningSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            runningSum = runningSum + arr[i] > arr[i] ? runningSum += arr[i] : arr[i];
            globalMax = runningSum > globalMax ? runningSum : globalMax;
        }
        return globalMax;
    }

    public int getMaxProductSubArray(Integer[] arr, int index, int runningProduct) {
        if (index >= arr.length)
            return runningProduct;
        else {
            return max(getMaxProductSubArray(arr, index + 1, runningProduct * arr[index]), 1);
        }
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

}
