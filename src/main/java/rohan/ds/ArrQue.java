package rohan.ds;

public class ArrQue {

    public int c = 0;

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
        if(d>=arr.length) return;
        if (e - s < d) {
            swap(arr,s,e);
            return;
        }
        int a1 = s, a2 = s + d-1, b1 = s + d, b2 = e;
        int lA = a2 - a1 + 1,lB = b2-b1 + 1;
        if(lA == lB) {
            blockSwap(arr,a1,a2,b1,b2);
            return;
        }
        else if(lA<lB) {
            blockSwap(arr, a1, a2, b2-lA +1, b2);
            rotate(arr,a1,b2-lA,d);
        } else {
            blockSwap(arr,a1,a2-lB,b1,b2);
            rotate(arr,a2-lB+1,b2,d);
        }
    }

    private void blockSwap(Integer[] arr, int s1, int e1, int s2, int e2) {
        for (int i = 0; i <= e1-s1; i++) {
            swap(arr, s1+i, i + s2);
        }
    }

    private void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
