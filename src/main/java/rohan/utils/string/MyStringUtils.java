package rohan.utils.string;

import java.util.Arrays;

import rohan.ds.Pair;

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
            return c + (m - i);
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
                arr[i][j] = minOfThree((x[i - 1] == y[j - 1] ? arr[i - 1][j - 1] : arr[i - 1][j - 1] + 1),
                        arr[i - 1][j] + 1, arr[i][j - 1] + 1);
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

    public Pair findSmallestWindow(String str1, String str2) {
        Pair index = new Pair();
        int count1[] = new int[256];
        int count2[] = new int[256];
        for (int i = 0; i < count1.length; i++) {
            count1[i] = count2[i] = 0;
        }
        for (int i = 0; i < str2.length(); i++) {
            count1[str2.charAt(i)]++;
            // count1[str2.charAt(i)]++;
        }
        int i = 0, j = 0, minLength = Integer.MAX_VALUE;
        while (j < str1.length()) {
            if (count1[str1.charAt(j)] > 0) {
                count2[str1.charAt(j)]++;
            }

            if (Arrays.equals(count1, count2) && j - i < minLength) {
                minLength = j - i;
            }
            if (minLength != Integer.MAX_VALUE) {
                if (str1.charAt(j) == str1.charAt(i)) {
                    count2[str1.charAt(i)]--;
                    i++;
                    while (i < j) {
                        if (!(count1[str1.charAt(i)] != 0 && count1[str1.charAt(i)] == count2[str1.charAt(i)]))
                            i++;
                    }
                }
            }
            j++;
        }
        index.first = i;
        index.second = j;
        return index;
    }

    public void printAllPerms(char str[]) {
        Arrays.sort(str);
        char[] temp = new char[str.length + 1];
        printAllPermsUtil(str, temp, 0);
    }

    public void printAllPermsUtil(char[] str, char[] temp, int index) {
        for (int i = 0; i < str.length; i++) {
            temp[index] = str[i];
            if (index == str.length - 1)
                System.out.println(temp);
            else {
                printAllPermsUtil(str, temp, index + 1);
            }
        }
    }

    public void printInterleavings(String str1, String str2, int i, int j, char[] temp, int k) {
        if (i == str1.length() && j == str2.length()) {
            System.out.println(temp);
        } else {
            if (i < str1.length()) {
                temp[k] = str1.charAt(i);
                printInterleavings(str1, str2, i + 1, j, temp, k + 1);
            }
            if (str2.length() > j) {
                temp[k] = str2.charAt(j);
                printInterleavings(str1, str2, i, j + 1, temp, k + 1);
            }
        }
    }

    public boolean checkInterleaving(String str1, String str2, String str3) {
        int i = 0, j = 0, k = 0;
        while (k != str3.length()) {
            if (i < str1.length() && str1.charAt(i) == str3.charAt(k)) {
                i++;
                k++;
            } else if (j < str2.length() && str2.charAt(j) == str3.charAt(k)) {
                j++;
                k++;
            } else
                return false;
        }
        return true;
    }

    public void printAllPermsLexigoraphically(char[] str) {
        Arrays.sort(str);
        System.out.println(str);
        int c,min;
        while ((c=getCand(str)) != -1) {
            min = c+1;
            for(int i=c+1;i<str.length;i++) {
                if(str[i]>str[c] && str[i]<str[min]) min = i;
            }
            swap(str,c,min);
            Arrays.sort(str,c+1,str.length);
            System.out.println(str);
        }
    }

    private int getCand(char[] str) {
        if(str.length<2) return -1;
        for (int i = str.length - 2; i >= 0; i--) {
            if(str[i]<str[i+1]) return i;
        }
        return -1;
    }

}
