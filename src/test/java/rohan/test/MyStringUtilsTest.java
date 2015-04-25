package rohan.test;

import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import rohan.utils.string.MyStringUtils;
import junitparams.JUnitParamsRunner;
import static junitparams.JUnitParamsRunner.$;

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
                "EXECUTION", 9 },new Object[] { "appropriate meaning", "approximate matching", 7 }
                );
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

}
