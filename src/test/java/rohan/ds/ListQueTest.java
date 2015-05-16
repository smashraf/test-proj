package rohan.ds;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListQueTest {
    
    ListQue listQue = new ListQue();
    
    MyList l1 = new MyList();
    
    @Before
    public void setup() {
        l1.addFirst(10);
        l1.addFirst(40);
        l1.addFirst(20);
        l1.addFirst(10);
        l1.addFirst(50);
        l1.printList();
    }
    
    @After
    public void tearApart() {
        l1 = null;
    }
    
    @Test
    public void reverseListTest() {
        l1.head = listQue.reverseList(l1.head);
        l1.printList();
    }
    
    @Test
    public void isPalindroneTest() {
        Assert.assertTrue(listQue.isPalindrone(l1.head));
    }
    
    @Test
    public void reversePairsTest() {
        l1.head = listQue.reversePairs(l1.head);
        l1.printList();
    }
    
    @Test
    public void reverseKTest() {
        l1.head = listQue.reverseK(l1.head, 3);
        l1.printList();
    }

}
