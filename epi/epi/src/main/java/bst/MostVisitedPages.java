package bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostVisitedPages {

	public List<String> mostVisitedPages(String[] words) {
		Map<String, Node> map = new HashMap<String, MostVisitedPages.Node>();
		BST bst = new BST();
		
		for(String word : words) {
			if(!map.containsKey(word)) {
				Node node = new Node(word, 1);
				map.put(word, node);
				bst.insert(node);
			} else {
				Node node = map.get(word);
				node.data++;
				bst.remove(node);
				bst.insert(node);
			}
		}
		
		// print the last k nodes in the bst
		return new ArrayList<String>();
	}
	
	public static class BST {
		Node root;
		
		public BST() {
			
		}
		
		public void insert(Node node) {
			
		}
		
		public void remove(Node node) {
			
		}
		
		
	}
	private static class Node extends TreeNode implements Comparable<Node> {

		private String word;

		public Node(int data) {
			super(data);
		}

		public Node(String word, int freq) {
			super(freq);
			this.word = word;
		}

		public int compareTo(Node o) {
			if(this.data == o.data) {
				return this.word.compareTo(o.word);
			} else {
				return this.data - o.data;
			}
		}
		

	}
}
