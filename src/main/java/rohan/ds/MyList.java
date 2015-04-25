package rohan.ds;

public class MyList {
    
    public ListNode head;
    
    public class ListNode {
        public int x;
        public ListNode next;
        
        public ListNode(int x) {
            this.x = x;
            next = null;
        }
    }
    
    public MyList() {
        head = null;
    }
    
    public void printList() {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.x + "\t");
            temp = temp.next;
        }
    }
    
    public void addFirst(int x) {
        ListNode temp = head;
        ListNode newNode = new ListNode(x);
        head = newNode;
        head.next = temp;
    }
    
    public ListNode removeFirst() {
        if(head == null) return null;
        ListNode temp = head;
        head = head.next;
        return temp;
    }
    
}
