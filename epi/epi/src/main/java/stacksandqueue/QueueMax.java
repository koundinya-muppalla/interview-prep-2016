package stacksandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class QueueMax {

    private Queue<Integer> elements;

    private Deque<Integer> maxQueue;

    int max = -1;

    public QueueMax() {
        this.elements = new LinkedList<Integer>();
        this.maxQueue = new LinkedList<Integer>();
    }

    public void offer(int val) {
        this.elements.offer(val);
        while(!maxQueue.isEmpty() && maxQueue.peekLast() < val) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(val);
    }

    public int poll() {
        int val = this.elements.poll();
        if(maxQueue.peekFirst() == val) {
            maxQueue.pollFirst();
        }
        return val;
    }

    public int max() {
        return maxQueue.peekFirst();
    }
}
