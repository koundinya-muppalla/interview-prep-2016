package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }

        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode prev = dummy, curr = head;

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        while(curr != null) {
            if(!map.containsKey(curr)) {
                map.put(curr, new RandomListNode(curr.data));
            }

            prev.next = map.get(curr);

            if(curr.random != null) {
                if(!map.containsKey(curr.random)) {
                    map.put(curr.random, new RandomListNode(curr.random.data));
                }
                prev.random = map.get(curr.random);
            }
            curr = curr.next;
            prev = prev.next;
        }
        return dummy.next;

    }

    private static class RandomListNode {
        int data;
        RandomListNode next;
        RandomListNode random;

        public RandomListNode(int data) {
            this.data = data;
        }
    }
}
