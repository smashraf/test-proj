package rohan.test;

import static junitparams.JUnitParamsRunner.$;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import rohan.utils.string.MyStringUtils;

@RunWith(JUnitParamsRunner.class)
public class MyStringUtilsTest {

    private MyStringUtils myStringUtils = new MyStringUtils();

    public static Object[] getString() {
        return $($("abc"), $("xyz"), $(""));
    }

    public static Object[] getCharArray() {
        return $($(new char[] { 'a', 'b', 'c', 'd', 'e' }, "acebd"), $(new char[] { 'a', 'b', 'c', 'd' }, "acbd"),
                $(new char[] { 'a', 'b', 'c' }, "acb"), $(new char[] { 'a', 'b', 'c', 'd', 'e', 'f' }, "acebdf"),
                $(new char[] { 'a', 'b' }, "ab"));
    }

    @Test
    @Parameters(method = "getString")
    public void reverseStringTest(String str) {
        String revStr = MyStringUtils.reverseString(str);
        Assert.assertEquals(str, MyStringUtils.reverseString(revStr));
    }

    @Test
    @Parameters(method = "getString")
    public void recursiveReverseStringTest(String str) {
        String revStr = MyStringUtils.recursiveReverseString(str);
        Assert.assertEquals(str, MyStringUtils.recursiveReverseString(revStr));
    }

    @Test
    @Parameters(method = "getCharArray")
    public void printOddEvenTest(char[] str, String out) {
        Assert.assertEquals(str.toString(), MyStringUtils.printOddEven(str));
    }

    public Object[] getStrings() {
        return $(new Object[] { "INTENTION", "EXECUTION", 5 }, new Object[] { "car", "abc", 3 }, new Object[] { "",
                "EXECUTION", 9 }, new Object[] { "appropriate meaning", "approximate matching", 7 });
    }

    public Object[] getStringsDp() {
        return $(new Object[] { "car", "abc", 3 });
    }

    @Test
    @Parameters(method = "getStrings")
    public void editDistTest(String str1, String str2, int ans) {
        char[] x = str1.toCharArray(), y = str2.toCharArray(), z = {};
        Assert.assertEquals(ans, myStringUtils.editDist(x, y, z, 0, 0, 0, x.length, y.length, 0));
    }

    @Test
    @Parameters(method = "getStrings")
    public void editDistDpTest(String str1, String str2, int ans) {
        char[] x = str1.toCharArray(), y = str2.toCharArray(), z = {};
        Assert.assertEquals(ans, myStringUtils.editDistDp(x, y, z, 0, 0, 0, x.length, y.length, 0));
    }

    @Test
    public void findSmallestWindowTest() {
        System.out.println(myStringUtils.findSmallestWindow("this is a test string", "tist"));
    }

    @Test
    public void printAllPermsTest() {
        myStringUtils.printAllPerms("ABC".toCharArray());
    }

    @Test
    public void printInterleavingsTest() {
        String str1 = "AB";
        String str2 = "CDE";
        myStringUtils.printInterleavings(str1, str2, 0, 0, new char[str1.length() + str2.length()], 0);
    }

    @Test
    public void checkInterleavingTest() {
        System.out.println(myStringUtils.checkInterleaving("AB", "CD", "ACBD"));
        System.out.println(myStringUtils.checkInterleaving("AB", "CD", "ADBC"));
    }

    @Test
    public void printAllPermsLexigoraphicallyTest() {
        myStringUtils.printAllPermsLexigoraphically("ABC".toCharArray());
    }

    @Test
    public void longestCommonSubstringTest() {
        System.out.println(myStringUtils.longestCommonSubstring("GEEKSFORGEEKS", "FEWGEEKS"));
    }

    @Test
    public void longestCommonSubseqTest() {
        System.out.println(myStringUtils.longestCommonSubseq("ABCA", "BDCA"));
        System.out.println(myStringUtils.longestPalindronicSubseq("ABBAC", 0, 0));
        System.out.println(myStringUtils.longestPalindronicSubseqRec("ABBAC", 0, 4));
    }

    @Test
    public void printWordsTest() {
        LinkedList<String> list = new LinkedList<>();
        list.add("utensilsoon");
        list.add("soonsoon");
        list.add("abcdef");
        list.add("suabb");
        String a = "soon";
        myStringUtils.printWords(list, a);
    }

    @Test
    public void reverseWordsTest() {
        myStringUtils.reverseWords("I love india".toCharArray());
    }

    @Test
    public void permutationsTest() {
        myStringUtils.permutations("ABC".toCharArray(), 0);
    }

    @Test
    public void printAnagramsTogetherTest() {
        String[] words = { "dog", "cat", "tac", "act", "god" };
        myStringUtils.printAnagramsTogether(words);
    }

    @Test
    public void printCombosTest() {
        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "ABC");
        map.put('2', "DEF");
        map.put('3', "GHI");
        map.put('4', "JKL");
        map.put('5', "MNO");
        map.put('6', "PQRS");
        map.put('7', "TUV");
        map.put('8', "WX");
        map.put('9', "YZ");
        char[] arr = new char[3];
        myStringUtils.printCombos(new char[] { '2', '3', '4' }, 0, arr, 0, map);

    }

    @Test
    public void printPossibleTest() {
        char[] arr = new char[20];
        myStringUtils.printPossible("ABCD".toCharArray(), 0, arr, 0);
    }
    
    @Test
    public void getMaxEqualHalfSubStringTest() {
        myStringUtils.getMaxEqualHalfSubString("1538023".toCharArray());
        myStringUtils.getMaxEqualHalfSubString("123123".toCharArray());
        myStringUtils.getMaxEqualHalfSubString("15".toCharArray());
        myStringUtils.getMaxEqualHalfSubString("11".toCharArray());
    }
    
    @Test
    public void getKUniquesTest() {
        myStringUtils.getKUniques("aabbcc".toCharArray(), 1);
        myStringUtils.getKUniques("aabbcc".toCharArray(), 3);
        myStringUtils.getKUniques("aabbcc".toCharArray(), 2);
        myStringUtils.getKUniques("aabacbebebe".toCharArray(), 3);
    }

}
