package rohan.ds;

import org.junit.Test;

public class MyListTest {
    
    MyList list1 = new MyList();
    
    @Test
    public void listTest() {
        list1.addFirst(20);
        list1.addFirst(40);
        list1.addFirst(20);
        list1.removeFirst();
        list1.printList();
    }

}
