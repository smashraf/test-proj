package rohan.utils.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
        int c, min;
        while ((c = getCand(str)) != -1) {
            min = c + 1;
            for (int i = c + 1; i < str.length; i++) {
                if (str[i] > str[c] && str[i] < str[min])
                    min = i;
            }
            swap(str, c, min);
            Arrays.sort(str, c + 1, str.length);
            System.out.println(str);
        }
    }

    private int getCand(char[] str) {
        if (str.length < 2)
            return -1;
        for (int i = str.length - 2; i >= 0; i--) {
            if (str[i] < str[i + 1])
                return i;
        }
        return -1;
    }

    public int longestCommonSubstring(String str1, String str2) {
        int[][] arr = new int[str1.length()][str2.length()];
        int max = 0;
        for (int i = 0; i < str1.length(); i++)
            for (int j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) == str1.charAt(i) && i - 1 > 0 && j - 1 > 0)
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                else if (str2.charAt(j) == str1.charAt(i))
                    arr[i][j] = 1;
                else
                    arr[i][j] = 0;
                if (arr[i][j] > max)
                    max = arr[i][j];
            }
        return max;
    }

    public int longestPalindronicSubstr(String str) {
        return longestCommonSubstring(str, reverseString(str));
    }

    public int longestPalindronicSubseqRec(String str, int begin, int end) {
        if (begin > end)
            return 0;
        else if (str.charAt(begin) == str.charAt(end))
            return longestPalindronicSubseqRec(str, begin + 1, end - 1) + 2;
        else
            return max(longestPalindronicSubseqRec(str, begin + 1, end),
                    longestPalindronicSubseqRec(str, begin, end - 1));
    }

    public int longestPalindronicSubseq(String str, int begin, int end) {

        // Same as longest common substring od str and rev of str
        return longestCommonSubseq(str, reverseString(str));
    }

    public int longestCommonSubseq(String str1, String str2) {
        int[][] arr = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    arr[i][j] = i - 1 >= 0 && j - 1 >= 0 ? arr[i - 1][j - 1] + 1 : 1;
                else {
                    if (i - 1 >= 0 && j - 1 >= 0)
                        arr[i][j] = max(arr[i - 1][j], arr[i][j - 1]);
                    else if (i - 1 >= 0 && j - 1 < 0)
                        arr[i][j] = arr[i - 1][j];
                    else if (i - 1 < 0 && j - 1 >= 0)
                        arr[i][j] = arr[i][j - 1];
                }
            }
        }
        return arr[str1.length() - 1][str2.length() - 1];
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    // Print all words
    public void printWords(LinkedList<String> str, String a) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (String s : str) {
            int i = 0;
            while (i < a.length()) {
                if (map.get(a.charAt(i)) == null)
                    map.put(a.charAt(i), 1);
                else
                    map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
                i++;
            }
            int count = 0;
            int j = 0;
            while (j < s.length()) {
                if (count == a.length()) {
                    System.out.println(s);
                    break;
                }
                if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) != 0) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    count++;
                }
                j++;
            }

        }
    }

    public void reverseWords(char[] str) {

        StringBuilder s = new StringBuilder();
        s.append(str);
        s.reverse();
        str = s.toString().toCharArray();
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
            if (i == str.length - 1) {
                reverse(str, start, i);
            }
        }
        System.out.println(str);
    }

    // print all permutations
    public void permutations(char[] str, int i) {
        if (i == str.length) {
            System.out.println(str);
        }
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            permutations(str, i + 1);
            swap(str, i, j);
        }
    }

    // interleaving of two strings

    public void reverse(char[] str, int start, int end) {
        if (start > end)
            return;
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;
        reverse(str, ++start, --end);
    }

    public void printAnagramsTogether(String[] inputWords) {
        Word[] words = new Word[inputWords.length];
        for (int i = 0; i < inputWords.length; i++) {
            Word wd = new Word();
            char[] st = inputWords[i].toCharArray();
            Arrays.sort(st);
            wd.str = String.valueOf(st);
            wd.index = i;
            words[i] = wd;
        }

        Arrays.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.str.compareTo(o2.str);
            }
        });

        for (Word wd : words) {
            System.out.println(inputWords[wd.index]);
        }

    }

    public class Word {
        public String str;
        public int index;

        @Override
        public String toString() {
            return "Word [str=" + str + ", index=" + index + "]";
        }

    }

    public void printCombos(char[] input, int index, char[] arr, int k, Map<Character, String> map) {
        if (k >= input.length) {
            System.out.println(arr);
            return;
        }
        for (int i = 0; i < map.get(input[index]).length(); i++) {
            arr[k] = map.get(input[index]).charAt(i);
            printCombos(input, index + 1, arr, k + 1, map);
        }
    }

    public void printPossible(char[] str, int index, char[] arr, int k) {
        if (index >= str.length) {
            System.out.println(arr);
            return;
        } else {
            arr[k] = str[index];
            printPossible(str, index + 1, arr, k + 1);
            if (k - 1 >= 0 && arr[k - 1] != ' ') {
                arr[k] = ' ';
                printPossible(str, index, arr, k + 1);
            }
        }

    }

    public void getMaxEqualHalfSubString(char[] str) {
        int[][] arr = new int[str.length][str.length];
        for (int i = 0; i < str.length; i++)
            for (int j = i; j < str.length; j++)
                if (j == i)
                    arr[i][j] = str[i] - '0';
                else
                    arr[i][j] = arr[i][j - 1] + str[j] - '0';
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j = j + 2) {
                int totalSum = 0, leftSum = 0;
                totalSum = arr[i][j];
                leftSum = arr[i][i + (j - i) / 2];
                if (leftSum * 2 == totalSum && max < j - i)
                    max = j - i + 1;
            }
        }
        System.out.println(max);
    }

    public void getKUniques(char[] str, int k) {
        int i = 0;
        int[] map = new int[26];
        int u = 0;
        int localStart = 0, localEnd = 0, globalStart = 0, globalEnd = 0;
        for (int j = 0; j < 26; j++)
            map[j] = 0;
        for (int j = 0; j < str.length; j++) {
            if (map[str[j] - 'a'] == 0) {
                u++;
                map[str[j] - 'a']++;
            }
            map[str[j] - 'a']++;
        }
        if (u < k) {
            System.out.println("Less than " + k + "uniques");
            return;
        }
        for (int j = 0; j < 26; j++)
            map[j] = 0;
        while (i < str.length) {
            map[str[i]-'a']++;
            localEnd++;
            while(!isValid(map,k)) {
                map[str[localStart]-'a']--;
                localStart++;
            }
            if(localEnd-localStart>globalEnd-globalStart) {
                globalEnd = localEnd;
                globalStart = localStart;
            }
            i++;
        }
        System.out.println(" " + globalStart + " " + globalEnd);
    }
    
    private boolean isValid(int[] map, int k) {
        int c=0;
        for(int i=0;i<26;i++) {
            if(map[i]>0)c++;
        }
        return k>=c;
    }

}
