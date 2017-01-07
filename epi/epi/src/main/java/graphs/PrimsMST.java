package graphs;

import graphs.Graph.Edge;
import graphs.Graph.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimsMST {

	public static List<Edge> primsMST(Graph G) {
		List<Edge> ret = new ArrayList<Graph.Edge>();
		BinaryMinHeap<Vertex> minHeap = new BinaryMinHeap<Graph.Vertex>();
		Map<Vertex, Edge> edgeMap = new HashMap<Graph.Vertex, Graph.Edge>();
		
		for(Vertex v : G.allVertex.values()) {
			minHeap.insert(v, Integer.MAX_VALUE);
		}
		Vertex source = G.allVertex.values().iterator().next();
		minHeap.insert(source, 0);
		
		while(!minHeap.isEmpty()) {
			BinaryMinHeap<Vertex>.Node minNode = minHeap.extractMinNode();
			Vertex curr = minNode.vertex;
			
			if(edgeMap.containsKey(curr)) {
				ret.add(edgeMap.get(curr));
			}

			for(Edge e : curr.edges) {
				Vertex adj = e.v;
				if(!minHeap.contains(adj)) {
					continue;
				}
				
				if(minHeap.getWeight(adj) > e.w) {
					minHeap.update(adj, e.w);
					edgeMap.put(adj, e);
				}
			}
		}
		
		return ret;
	}
}