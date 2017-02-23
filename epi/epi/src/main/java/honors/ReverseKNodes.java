package honors;

public class ReverseKNodes {

    
    public static ListNode reverseK(ListNode head, int k) {
        if(head == null || k <= 0) {
            return head;
        }
        
        ListNode curr = head, prev = null, next = null;
        int count = 0;
        while(curr != null && count <  k) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        
        if(count != k) {
            return head;
        }
        
        ListNode nextHead = reverseK(curr, k);
        prev.next = null;
        
        prev = null; 
        curr = head; 
        next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head.next = nextHead;
        return prev;
    }
    

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        
        ListNode newHead = reverseK(one, 3);
        while(newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }
    
    private static class ListNode {
        int data;
        ListNode next;
        
        public ListNode(int data) {
            this.data = data;
        }
    }
}
