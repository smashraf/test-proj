package rohan.ds;

import rohan.junit.LargestZeroSum;

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

    public int lis(int arr[]) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && temp[i] < temp[j] + 1)
                    temp[i] = temp[j] + 1;
            }
        }
        return getArrayMax(temp);
    }

    private int getArrayMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i)
                max = i;
        }
        return max;
    }

    public int getLongestBitonicSeq(int[] arr) {
        int[] lis = new int[arr.length];
        int[] lds = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lis[i] = 1;
            lds[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (lis[i] < lis[j] + 1 && arr[i] > arr[j])
                    lis[i] = lis[j] + 1;
                if (lds[i] < lds[j] + 1 && arr[i] < arr[j])
                    lds[i] = lds[j] + 1;
            }
        }

        int max = lis[0] + lds[0];
        for (int i = 1; i < arr.length; i++) {
            if (lis[i] + lds[i] > max)
                max = lis[i] + lds[i];
        }
        return max - 1;
    }

    public int findMaxChain(Pair[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            temp[i] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j].second < arr[i].first && temp[i] < temp[j] + 1)
                    temp[i] = temp[j] + 1;
            }
        }
        return getArrayMax(temp);
    }

    public void sizeThreeSubSeq(int[] arr) {
        // Fill here after u forget the solution
    }

    public Pair getMaxSubArrayForSum(int[] arr, int n) {
        Pair pair = new Pair();
        pair.first = 0;
        pair.second = 0;
        int sum = arr[0], start = 0, maxDiff = 0;
        for (int i = 1; i <= arr.length; i++) {
            if (sum > n) {
                while (sum > n && start < i - 1) {
                    sum -= arr[start];
                    start++;
                }
            }
            if (sum == n && maxDiff < i - start) {
                pair.first = start;
                pair.second = i - 1;
                maxDiff = i - start;
            }
            if (i < arr.length) {
                sum += arr[i];
            }
        }
        return pair;
    }

    public int getLargestZeroOneSubArray(Integer[] arr) {
        LargestZeroSum largestZeroSum = new LargestZeroSum();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                arr[i] = -1;
        }
        return largestZeroSum.getLargestSumSetSmart(arr, 1, 2, 3);
    }

}
