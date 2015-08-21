package rohan.ds;

import org.junit.Assert;
import org.junit.Test;

public class MathematicalQueTest {

    MathematicalQue mathematicalQue = new MathematicalQue();

    @Test
    public void printCombosTest() {
        mathematicalQue.printCombos(4, new int[4], 0);
        System.out.println("------");
        mathematicalQue.printCombos(3, new int[3], 0);
    }
    
    @Test
    public void isLuckyTest() {
        Assert.assertTrue(mathematicalQue.isLucky(7, 2));
        Assert.assertFalse(mathematicalQue.isLucky(9, 2));
        Assert.assertFalse(mathematicalQue.isLucky(8, 2));
        
        
    }

}
