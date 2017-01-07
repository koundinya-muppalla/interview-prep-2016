package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MergeKSortedArray {
	
	public static List<Integer> mergeKSortedArray(List<List<Integer>> lists) {
		List<Integer> ret = new ArrayList<Integer>();
		if(lists == null || lists.isEmpty()) {
			return ret;
		}
		
		PriorityQueue<ArrayEntry> pq = new PriorityQueue<MergeKSortedArray.ArrayEntry>(10, new Comparator<ArrayEntry>() {

			public int compare(ArrayEntry o1, ArrayEntry o2) {
				// TODO Auto-generated method stub
				return o1.value - o2.value;
			}
		});
		
		Map<Integer, Iterator<Integer>> map = new HashMap<Integer, Iterator<Integer>>();
		int i = 0;
		for(List<Integer> list : lists) {
			if(list != null && !list.isEmpty()) {
				Iterator<Integer> it = list.iterator();
				map.put(i, it);
				pq.add(new ArrayEntry(it.next(), i));
				i++;
			}
		}
		
		while(!pq.isEmpty()) {
			ArrayEntry top = pq.poll();
			ret.add(top.value);
			if(map.get(top.index).hasNext()) {
				pq.offer(new ArrayEntry(map.get(top.index).next(), top.index));
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(3,5,7);
		List<Integer> list2 = Arrays.asList(0,6);
		List<Integer> list3 = Arrays.asList(0,6,28);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		System.out.println(mergeKSortedArray(lists));
	}
	private static class ArrayEntry {
		int value;
		int index;
		
		public ArrayEntry(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
