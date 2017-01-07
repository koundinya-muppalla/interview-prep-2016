package hashtable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import common.Pair;

public class TopKFrequentElements {

	public static List<String> topK(String[] strings, int k) {
		List<String> ret = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<Pair<String,Integer>>(10, new Comparator<Pair<String, Integer>>() {
			public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
				return (Integer)o1.second - (Integer)o2.second;
			}
		});
		
		
		for(String s : strings) {
			if(!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}
		
		for(String s : map.keySet()) {
			System.out.println(s + "-" + map.get(s));
			if(pq.size() < k) {
				pq.offer(new Pair<String, Integer>(s, map.get(s)));
			} else {
				if(map.get(s) >  pq.peek().second) {
					pq.poll();
					pq.offer(new Pair<String, Integer>(s, map.get(s)));
				}
			}
		}
		
		
		while(!pq.isEmpty()) {
			ret.add(pq.poll().first);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		String s = "hi how are you and how are you doing hi again what are you talking about man again";
		System.out.println(topK(s.split(" "), 5));
	}
}
