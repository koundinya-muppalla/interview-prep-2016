package honors;

public class ListZipping {

    public static ListNode zip(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        
        ListNode curr = head, middle = reverse(middle(head));
        ListNode dummy = new ListNode(0), prev = dummy;
        boolean current = true;
        while(curr != null && middle != null) {
            if(current) {
                prev.next = curr;
                curr = curr.next;
                current = !current;
            } else {
                prev.next = middle;
                middle = middle.next;
                current = !current;
            }
            prev = prev.next;
        }
        if(curr != null) {
            prev.next = curr;
        }
        
        if(middle != null) {
            prev.next = middle;
        }
        return dummy.next;
    }
    
    private static ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode middle(ListNode head) {
        ListNode slow = head, fast = head.next, prev = null;
        while(slow != null && fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }
        
        // break the middle
        if(prev != null) {
            prev.next = null;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        ListNode newHead = zip(one);
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
