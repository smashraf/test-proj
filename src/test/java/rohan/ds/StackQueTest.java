package rohan.ds;

import org.junit.Assert;
import org.junit.Test;

public class StackQueTest {

    private StackQue stackQue = new StackQue();

    @Test
    public void verifyBalanceTest() {
        Assert.assertTrue(stackQue.verifyBalance("(2+2)"));
        Assert.assertFalse(stackQue.verifyBalance("({}2+2)"));
        Assert.assertTrue(stackQue.verifyBalance("{(2+2)}[3+2]"));
        Assert.assertFalse(stackQue.verifyBalance("{(2+2)}([3+2])"));
        Assert.assertTrue(stackQue.verifyBalance("[()]{}[[()()]()]"));
    }

}
