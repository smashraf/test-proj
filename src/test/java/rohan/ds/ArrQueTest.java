package rohan.ds;

import java.util.Arrays;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ArrQueTest {

    private ArrQue arrQue = new ArrQue();

    public Object[] getArrays() {
        return new Object[] { new Object[] { new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 2, 3, 4, 5 } },
                new Object[] { new int[] { 2, 4, 1, 3, 5 }, new int[] { 1, 2, 3, 4, 5 } },
                new Object[] { new int[] { 2, 4, 1 }, new int[] { 1, 2, 4 } } };
    }

    public Object[] getArray() {
        return new Object[] { new Object[] { new int[] { 1, 2, 2, 2, 5 }, 2, 1 }, new Object[] { new int[] {}, 2, -1 } };
    }

    @Test
    @Parameters(method = "getArrays")
    public void mergeSortTest(int[] arr1, int[] arr2) {
        arrQue.mergeSort(arr1, 0, arr1.length - 1);
        System.out.println(arrQue.c);
        Assert.assertArrayEquals(arr2, arr1);
    }

    @Test
    @Parameters(method = "getArray")
    public void binSrchMinTest(int[] arr, int x, int ans) {
        Assert.assertEquals(ans, arrQue.binSrchMin(arr, 0, arr.length - 1, x));
    }

    @Test
    @Parameters(method = "getArray")
    public void binSrchMaxTest(int[] arr, int x, int ans) {
        Assert.assertEquals(3, arrQue.binSrchMax(arr, 0, arr.length - 1, 2));
    }

    public Object[] getArrayForRotation() {
        return new Object[] {
                new Object[] { new Integer[] { 1, 2, 3, 4, 5 }, 0, 4, 2, new Integer[] { 3, 4, 5, 1, 2 } },
                new Object[] { new Integer[] { 1, 2, 3, 4, 5, 6 }, 0, 5, 2, new Integer[] { 3, 4, 5, 6, 1, 2 } },
                new Object[] { new Integer[] { 1, 2, 3 }, 0, 2, 2, new Integer[] { 3, 1, 2 } },
                new Object[] { new Integer[] { 1, 2, 3 }, 0, 2, 3, new Integer[] { 1, 2, 3 } } };
    }

    @Test
    @Parameters(method = "getArrayForRotation")
    public void rotateTest(Integer[] arr, int s, int e, int d, Integer[] ans) {
        arrQue.rotate(arr, s, e, d);
        Assert.assertArrayEquals(ans, arr);
    }
    
    @Test
    public void spiralPrintTest() {
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        arrQue.spiralPrint(3, 4, arr);
    }

    public Object[] getTripletArray() {
        return new Object[] { new Object[] { new int[] { 1, 4, 45, 6, 10, 8 }, 22 },
                new Object[] { new int[] { 12, 3, 4, 1, 6, 9 }, 24 } };
    }

    @Test
    @Parameters(method = "getTripletArray")
    public void hasTripletTest(int[] arr, int n) {
        Assert.assertTrue(arrQue.hasTriplet(arr, n));
    }

    @Test
    public void getQuadrupleTest() {
        int[] arr = { 10, 2, 3, 4, 5, 9, 7, 8 };
        System.out.println(arrQue.getQuadruple(arr, 23).toString());
    }

    public Object[] getPartitionArray() {
        return new Object[] { new Object[] { new int[] { 1, 5, 11, 5 }, true },
                new Object[] { new int[] { 1, 5, 11 }, false } };
    }

    @Test
    @Parameters(method = "getPartitionArray")
    public void hasPartitionTest(int[] arr, boolean ans) {
        Assert.assertEquals(ans, arrQue.hasPartition(arr));
    }

    @Test
    public void subSetSumDpTest() {
        int[] arr = new int[] { 1, 5, 11, 5 };
        System.out.println(arrQue.subSetSumDp(arr, -10000, 11));
    }

    @Test
    public void minJumpsTest() {
        int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        System.out.println(arrQue.minJumps(arr, 1, 0));
    }

    @Test
    public void getMaxOneRowTest() {
        int[][] arr = { { 0, 0, 0, 0 }, { 0, 0, 1, 1 }, { 0, 1, 1, 1 }, { 0, 0, 0, 0 } };
        System.out.println(arrQue.getMaxOneRow(arr));
    }

    @Test
    public void printUniqueRowsTest() {
        int[][] arr = { { 0, 0, 0, 0 }, { 1, 0, 1, 1 }, { 0, 1, 1, 1 }, { 0, 0, 0, 0 } };
        arrQue.printUniqueRows(arr);
    }

    public Object[] getMaxDiffArray() {
        return new Object[] { new Object[] { new int[] { 2, 3, 10, 6, 4, 8, 1 }, 8 },
                new Object[] { new int[] { 7, 9, 5, 6, 3, 2 }, 2 } };
    }

    @Test
    @Parameters(method = "getMaxDiffArray")
    public void maxDiffTest(int arr[], int ans) {
        Assert.assertEquals(ans, arrQue.maxDiff(arr));
    }

    public Object[] getTriangleCountArray() {
        return new Object[] { new Object[] { new int[] { 4, 6, 3, 7 }, 3 },
                new Object[] { new int[] { 10, 21, 22, 100, 101, 200, 300 }, 6 } };
    }

    @Test
    @Parameters(method = "getTriangleCountArray")
    public void countTriangleTest(int[] arr, int ans) {
        Assert.assertEquals(ans, arrQue.countTriangle(arr));
    }

    public Object[] getPumps() {
        return new Object[] {
                new Object[] {
                        new Pair[] { new Pair(4, 6), new Pair(6, 5), new Pair(7, 3), new Pair(5, 11), new Pair(4, 1) },
                        4 },
                new Object[] { new Pair[] { new Pair(4, 6), new Pair(6, 5), new Pair(7, 3), new Pair(4, 5) }, 1 },
                new Object[] { new Pair[] { new Pair(6, 4), new Pair(3, 6), new Pair(7, 3) }, 2 },
                new Object[] { new Pair[] { new Pair(3, 6), new Pair(1, 1113) }, -1 } };
    }

    @Test
    @Parameters(method = "getPumps")
    public void getFirstPumpTest(Pair[] pumps, int ans) {
        Assert.assertEquals(ans, arrQue.getFirstPump(pumps));
    }

    @Test
    public void printLargestTest() {
        Integer[] arr = { 54, 546, 548, 60 };
        System.out.println(arrQue.printLargest(arr));
    }

    @Test
    public void maxSubMatrixTest() {
        int[][] arr = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
        System.out.println(arrQue.maxSubMatrix(arr));
    }

    @Test
    public void pancakeSortTest() {
        int arr[] = { 23, 10, 20, 11, 12, 6, 7 };
        arrQue.pancakeSort(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public Object[] getArrayForSorting() {
        return new Object[] { new Object[] { new int[] { 11, 10, 23, 20 }, 2 },
                new Object[] { new int[] { 23, 10, 20, 11, 12, 6, 7 }, 1 } };
    }

    @Test
    @Parameters(method = "getArrayForSorting")
    public void qPartitionTest(int[] arr, int ans) {

        Assert.assertEquals(ans, arrQue.qPartition(arr, 0, arr.length - 1));
    }

    @Test
    public void qSortTest() {
        //int arr[] = { 23, 10, 20, 11, 12, 6, 7 };
        int [] arr = {};
        arrQue.qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
