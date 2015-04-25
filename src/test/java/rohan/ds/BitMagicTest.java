package rohan.ds;

import org.junit.Assert;
import org.junit.Test;

public class BitMagicTest {
    
    BitMagic bitMagic = new BitMagic();
    @Test
    public void getNextPowerOfTwoTest() {
        Assert.assertTrue(bitMagic.getNextPowerOfTwo(5)==8);
        Assert.assertTrue(bitMagic.getNextPowerOfTwo(0)==0);
        Assert.assertTrue(bitMagic.getNextPowerOfTwo(8)==8);
        Assert.assertTrue(bitMagic.getNextPowerOfTwo(9)==16);
    }
    
    @Test
    public void isMultipleOfThreeTest() {
        Assert.assertTrue(bitMagic.isMultipleOfThree(9));
        Assert.assertFalse(bitMagic.isMultipleOfThree(8));
        Assert.assertTrue(bitMagic.isMultipleOfThree(21));
        Assert.assertFalse(bitMagic.isMultipleOfThree(31));
    }
    
    @Test
    public void getOddOccuringTest() {
        Assert.assertEquals(1,bitMagic.getOddOccuring(new int []{1,2,2}));
    }
}
