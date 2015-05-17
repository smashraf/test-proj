package rohan.ds;

public class MaxHeap {

    public int[] arr;

    int size;

    public MaxHeap(int size) {
        arr = new int[size];
    }

    public int getParent(int index) {
        if (index - 1 >= 0)
            return (index - 1) / 2;
        else
            return -1;
    }

    public int getLeft(int i) {
        return 2 * i + 1;
    }

    public int getRight(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapify(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && arr[index] < arr[left])
            swap(index, left);
        else if (right < size && arr[index] < arr[right])
            swap(index, right);
    }

    public void insert(int x) {
        arr[size] = x;
        size++;
        for (int i = getParent(size-1); i >= 0;) {
            heapify(i);
            i = getParent(i);
        }
    }
    
}
