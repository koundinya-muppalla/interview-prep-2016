package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap<T> {

	List<Node> allNodes = new ArrayList<Node>();
	Map<Node, Integer> nodePositions = new HashMap<Node, Integer>();


	public T extractMin() {
		return null;
	}
	
	public Node extractMinNode() {
		return null;
	}

	public boolean contains(T vertex) {
		return false;
	}

	public void insert(T vertex, int weight) {

	}

	public void update(T vertex, int weight) {

	}

	public int getWeight(T vertex) {
		return 0;
	}

	public boolean isEmpty() {
		return true;
	}
	
	public class Node {
		T vertex;
		int weight;

		public Node(T vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}
