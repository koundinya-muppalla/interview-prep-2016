package graphs;

import graphs.Graph.Edge;
import graphs.Graph.Vertex;

import java.util.HashMap;
import java.util.Map;

public class DijkstrasShortestPath {

	public Map<Vertex, Integer> shortestPath(Graph g, Vertex source) {
		Map<Vertex, Integer> distance = new HashMap<Vertex, Integer>();
		Map<Vertex, Vertex> parent = new HashMap<Graph.Vertex, Graph.Vertex>();
		BinaryMinHeap<Vertex> minHeap = new BinaryMinHeap<Vertex>();

		for(Vertex v : g.allVertex.values()) {
			minHeap.insert(v, Integer.MAX_VALUE);
		}

		minHeap.update(source, 0);
		parent.put(source, null);
		distance.put(source, 0);

		while(!minHeap.isEmpty()) {
			BinaryMinHeap<Vertex>.Node minNode = minHeap.extractMinNode();
			Vertex curr = minNode.vertex;
			distance.put(curr, minNode.weight);
			
			for(Edge e : curr.edges) {
				Vertex neighbor = e.v;
				if(!minHeap.contains(neighbor)) {
					continue;
				}

				int newDistance = e.w + distance.get(curr);
				
				if(minHeap.getWeight(neighbor) > newDistance) {
					minHeap.update(neighbor, newDistance);
					parent.put(neighbor, curr);
				}
			}
		}
		
		return distance;
	}
}
