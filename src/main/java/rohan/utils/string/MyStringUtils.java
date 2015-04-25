package rohan.utils.string;

public class MyStringUtils {

    public static String reverseString(String s) {
        StringBuilder revStr = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            revStr.append(s.charAt(i));
        }
        return revStr.toString();
    }

    public static String recursiveReverseString(String s) {
        if (s.length() == 0)
            return s;
        return recursiveReverseString(s.substring(1)) + s.charAt(0);
    }

    public static String printOddEven(char[] str) {
        if (str.length == 0 || str.length == 1)
            return str.toString();
        int i = (str.length - 1) % 2 == 0 ? (str.length - 1) : str.length - 2;
        int j = i - 1;
        while (j > 0) {
            if (i % 2 == 0) {
                swap(str, i, j);
                i--;
                j--;
            } else {
                j--;
                swap(str, i, j);
                i--;
            }
        }
        return str.toString();
    }

    public static void swap(char[] str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }

    public int editDist(char[] x, char[] y, char[] z, int i, int j, int k, int m, int n, int c) {
        if (j >= n)
            return c + (m-i);
        if (i >= m)
            return c + (n - j);

        return minOfThree(
                (x[i] == y[j] ? editDist(x, y, z, i + 1, j + 1, k, m, n, c) : editDist(x, y, z, i + 1, j + 1, k, m, n,
                        c + 1)), editDist(x, y, z, i + 1, j, k + 1, m, n, c + 1),
                editDist(x, y, z, i, j + 1, k + 1, m, n, c + 1));

    }

    private int minOfThree(int a, int b, int c) {
        if (a < b && a < c)
            return a;
        else if (b < a && b < c)
            return b;
        else
            return c;
    }

    public int editDistDp(char[] x, char[] y, char[] z, int i1, int j1, int k1, int m, int n, int c) {
        int[][] arr = new int[m + 1][n + 1];
        arr[0][0] = 0;
        for (int i = 1; i <= m; i++)
            arr[i][0] = arr[i - 1][0] + 1;
        for (int j = 1; j <= n; j++)
            arr[0][j] = arr[0][j - 1] + 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = minOfThree((x[i-1]==y[j-1]?arr[i-1][j-1]:arr[i-1][j-1]+1),arr[i-1][j] +1, arr[i][j-1]+1);
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        return arr[m][n];
    }

}
