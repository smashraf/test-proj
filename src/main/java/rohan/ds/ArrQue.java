package rohan.ds;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrQue {

    public int c = 0;

    public DpQue dpQue = new DpQue();

    public void mergeSort(int[] arr, int p, int q) {
        if (p < q) {
            int r = p + (q - p) / 2;
            mergeSort(arr, p, r);
            mergeSort(arr, r + 1, q);
            merge(arr, p, r, q);
        }
    }

    public void merge(int[] arr, int p, int r, int q) {
        int[] temp1 = new int[r - p + 2];
        int[] temp2 = new int[q - r + 1];
        int i = 0, j = 0, k = 0;
        for (i = p; i <= r; i++) {
            temp1[k++] = arr[i];
        }
        temp1[k] = Integer.MAX_VALUE;
        k = 0;
        for (i = r + 1; i <= q; i++) {
            temp2[k++] = arr[i];
        }
        temp2[k] = Integer.MAX_VALUE;
        i = 0;
        j = 0;
        for (k = p; k <= q; k++) {
            if (temp1[i] > temp2[j]) {
                if (temp1[i] != Integer.MAX_VALUE)
                    c = c + temp1.length - 1 - i;
                arr[k] = temp2[j++];

            } else {
                arr[k] = temp1[i++];
            }
        }
    }

    public int binSrchMin(int[] arr, int low, int high, int x) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                if (mid - 1 >= low && arr[mid - 1] == x)
                    return binSrchMin(arr, low, mid - 1, x);
                else
                    return mid;
            } else if (arr[mid] > x)
                return binSrchMin(arr, low, mid - 1, x);
            else
                return binSrchMin(arr, mid + 1, high, x);
        }
        return -1;
    }

    public int binSrchMax(int[] arr, int low, int high, int x) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                if (mid + 1 <= high && arr[mid + 1] == x)
                    return binSrchMax(arr, mid + 1, high, x);
                else
                    return mid;
            } else if (arr[mid] >= x)
                return binSrchMax(arr, mid + 1, high, x);
            else
                return binSrchMax(arr, low, mid - 1, x);
        }
        return -1;
    }

    public void rotate(Integer[] arr, int s, int e, int d) {
        if (d >= arr.length)
            return;
        if (e - s < d) {
            swap(arr, s, e);
            return;
        }
        int a1 = s, a2 = s + d - 1, b1 = s + d, b2 = e;
        int lA = a2 - a1 + 1, lB = b2 - b1 + 1;
        if (lA == lB) {
            blockSwap(arr, a1, a2, b1, b2);
            return;
        } else if (lA < lB) {
            blockSwap(arr, a1, a2, b2 - lA + 1, b2);
            rotate(arr, a1, b2 - lA, d);
        } else {
            blockSwap(arr, a1, a2 - lB, b1, b2);
            rotate(arr, a2 - lB + 1, b2, d);
        }
    }

    private void blockSwap(Integer[] arr, int s1, int e1, int s2, int e2) {
        for (int i = 0; i <= e1 - s1; i++) {
            swap(arr, s1 + i, i + s2);
        }
    }

    private void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void spiralPrint(int m, int n, int a[][]) {
        int i, k = 0, l = 0;
        
       
     
        while (k < m && l < n)
        {
            /* Print the first row from the remaining rows */
            for (i = l; i < n; ++i)
            {
                System.out.print(a[k][i]+" ");
            }
            k++;
     
            /* Print the last column from the remaining columns */
            for (i = k; i < m; ++i)
            {
                System.out.print(a[i][n-1]+" " );
            }
            n--;
     
            /* Print the last row from the remaining rows */
            if ( k < m)
            {
                for (i = n-1; i >= l; --i)
                {
                    System.out.print(a[m-1][i]+" ");
                }
                m--;
            }
     
            /* Print the first column from the remaining columns */
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    System.out.print(a[i][l]+" ");
                }
                l++;    
            }        
        }
    }

    public boolean hasTriplet(int[] arr, int n) {
        if (arr.length < 3)
            return false;
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1, k = arr.length - 1;
            int sum = n - arr[i];
            while (j < k) {
                if (arr[j] + arr[k] == sum)
                    return true;
                else if (arr[j] + arr[k] > sum)
                    k--;
                else
                    j++;
            }
        }
        return false;
    }

    public Set<Integer> getQuadruple(int[] arr, int n) {
        if (arr.length < 4)
            return null;
        Set<Integer> quadSet = new HashSet<>();
        PairSum[] aux = new PairSum[arr.length * (arr.length - 1) / 2];
        // Generating all possible pairs
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                aux[k] = new PairSum();
                aux[k].sum = arr[i] + arr[j];
                aux[k].firstIndex = i;
                aux[k].secondIndex = j;
                k++;
            }
        }
        Arrays.sort(aux, new Comparator<PairSum>() {
            @Override
            public int compare(PairSum o1, PairSum o2) {
                return Integer.compare(o1.sum, o2.sum);
            }
        });
        int left = 0, right = aux.length - 1;
        while (left < right) {
            if (aux[left].sum + aux[right].sum == n && aux[left].firstIndex != aux[right].firstIndex
                    && aux[left].firstIndex != aux[right].secondIndex && aux[left].secondIndex != aux[right].firstIndex
                    && aux[left].secondIndex != aux[right].secondIndex) {
                quadSet.add(arr[aux[left].firstIndex]);
                quadSet.add(arr[aux[left].secondIndex]);
                quadSet.add(arr[aux[right].firstIndex]);
                quadSet.add(arr[aux[right].secondIndex]);
                return quadSet;
            } else if (aux[left].sum + aux[right].sum < n)
                left++;
            else
                right--;
        }
        return quadSet;
    }

    public boolean hasPartition(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum % 2 == 0 ? subSetSum(arr, 0, sum / 2) : false;
    }

    public boolean subSetSum(int[] arr, int i, int n) {
        if (n == 0)
            return true;
        else if (i >= n)
            return false;
        else
            return subSetSum(arr, i + 1, n - arr[i]) || subSetSum(arr, i + 1, n);
    }

    public boolean subSetSumDp(int[] arr, int dummy1, int n) {
        boolean[][] mat = new boolean[arr.length + 1][n + 1];
        for (int j = 0; j <= n; j++)
            mat[0][j] = false;
        for (int i = 0; i <= arr.length; i++)
            mat[i][0] = true;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= n; j++) {
                mat[i][j] = mat[i - 1][j] || (j - arr[i - 1] >= 0 ? mat[j - arr[i - 1]][j - 1] : false);
            }
        }
        return mat[arr.length - 1][n];
    }

    public int minJumps(int[] arr, int index, int c) {
        if (index >= arr.length - 1)
            return c;
        if (index == 0)
            return c + 1;
        else {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < index; k++) {
                if (index - k <= arr[k] && min > index - k) {
                    min = index - k;
                }
            }
            return c + min;
        }

    }

    public void getLISSmart(int[] arr) {
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {

        }
    }

    public int getMaxOneRow(int[][] arr) {
        // find first 1 in first row
        int indexLeftMostOne = arr.length - 1;
        int row = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[0][i] == 1) {
                indexLeftMostOne = i;
                break;
            }

        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][indexLeftMostOne] == 0)
                continue;
            else {
                int j = indexLeftMostOne;
                while (j >= 0 && arr[i][j] == 1) {
                    indexLeftMostOne = j;
                    j--;
                }
                row = i;
            }
        }
        return row;
    }

    public void printUniqueRows(int[][] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = 0;
            for (int j = 0; j < arr.length; j++) {
                num += arr[i][j] == 1 ? Math.pow(2, j) : 0;
            }
            map.put(num, i);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public int maxDiff(int[] arr) {
        int i, j;
        i = 0;
        j = 1;
        int globalDiff = 0;
        int localDiff;
        while (j < arr.length) {
            if (arr[j] > arr[i]) {
                localDiff = arr[j] - arr[i];
                if (localDiff > globalDiff)
                    globalDiff = localDiff;
                j++;
            } else {
                while (i < j) {
                    if (arr[i] < arr[j]) {
                        localDiff = arr[j] - arr[i];
                        if (localDiff > globalDiff)
                            globalDiff = localDiff;
                    }
                    i++;
                }
                j++;
            }
        }
        return globalDiff;
    }

    public int countTriangle(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        int i = 0, j = 1, k, count = 0;
        for (i = 0; i < arr.length - 2; i++) {
            k = i + 2;
            for (j = i + 1; j < arr.length - 1; j++) {
                while (k < arr.length && arr[i] + arr[j] > arr[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }

    public int getFirstPump(Pair[] pumps) {
        int i = 0, j = 0;
        int sum = 0;
        while (j + 1 != (i % pumps.length)) {
            sum += (pumps[j].first - pumps[j].second);
            while (sum < 0 && i <= j) {
                if (i == pumps.length - 1)
                    i = 0;
                sum += (pumps[i].second - pumps[i].first);
                i++;
            }
            j++;
            if (j == pumps.length - 1)
                j = 0;
        }
        if (sum <= 0)
            return -1;
        return i;
    }

    public String printLargest(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int diff = o1.toString().length() - o2.toString().length();
                if (diff > 0)
                    o2 *= (int) Math.pow(10, diff);
                else if (diff < 0)
                    o1 *= (int) Math.pow(10, (-1) * diff);
                return Integer.compare(o2, o1);
            }
        });
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]);
        }
        return str.toString();
    }

    /*
     * Read from this link when in doubt
     * http://prismoskills.appspot.com/lessons/
     * Dynamic_Programming/Chapter_07_-_Submatrix_with_largest_sum.jsp
     */
    public int maxSubMatrix(int matrix[][]) {
        int globalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            Integer temp[] = new Integer[matrix.length];
            for (int k = 0; k < temp.length; k++)
                temp[k] = 0;
            for (int j = i; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++)
                    temp[k] += matrix[k][j];
                int sum = dpQue.kadane(temp);
                if (sum > globalSum)
                    globalSum = sum;
            }
        }
        return globalSum;
    }

    public void pancakeSort(int[] arr, int end) {
        if (end <= 0)
            return;
        int max = arr[0], maxIndex = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        if (maxIndex != end) {
            flip(arr, maxIndex);
            flip(arr, end);
        }
        pancakeSort(arr, end - 1);
    }

    private void flip(int[] arr, int end) {
        int i = 0, j = end;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public int qPartition(int arr[], int start, int end) {
        int i = start, j = end - 1;
        while (i <= j) {
            while (j >= i && arr[j] > arr[end])
                j--;
            if (j < i)
                break;
            if (arr[i] > arr[end]) {
                swap(arr, i, j);
            }
            i++;
        }
        swap(arr, i, end);
        return i;
    }

    public void qSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = qPartition(arr, start, end);
            qSort(arr, start, p - 1);
            qSort(arr, p + 1, end);
        }
    }

}
