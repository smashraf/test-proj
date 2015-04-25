package rohan.junit;

import static junitparams.JUnitParamsRunner.$;

import java.util.Arrays;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class NextIntegerTest {
    private NextInteger nextInteger = new NextInteger();

    public Object[] getArray() {
        return $($(new int[] { 2, 4, 3, 7, 8, 6, 5, 2 }, new int[] { 4, 7, 7, 8, -1, -1, -1, -1 }),
                $(new int[] { 1, 2, 3 }, new int[] { 2, 3, -1 }));
    }

    @Test
    @Parameters(method = "getArray")
    public void getNextIntTest(int[] arr, int[] ans) {
        Assert.assertArrayEquals(ans, nextInteger.getNextInt(arr));
    }
}
