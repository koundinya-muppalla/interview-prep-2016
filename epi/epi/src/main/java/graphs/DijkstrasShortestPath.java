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

    private Map<Vertex, Integer> shortest(Graph g, Vertex source) {
        Map<Vertex, Integer> distance = new HashMap<Graph.Vertex, Integer>();
        BinaryMinHeap<Vertex> heap = new BinaryMinHeap<Graph.Vertex>();
        Map<Vertex, Vertex> parent = new HashMap<Graph.Vertex, Graph.Vertex>();

        for(Vertex v : g.allVertex.values()) {
            distance.put(v, Integer.MAX_VALUE);
            parent.put(v, null);
            heap.insert(v, Integer.MAX_VALUE);
        }

        heap.update(source, 0);
        distance.put(source, 0);
        parent.put(source, null);


        while(!heap.isEmpty()) {
            BinaryMinHeap<Vertex>.Node minNode = heap.extractMinNode();
            Vertex curr = minNode.vertex;
            distance.put(curr, minNode.weight);

            for(Edge edge : curr.edges) {
                if(!heap.contains(edge.v)) continue;

                if(distance.get(curr) + edge.w < distance.get(edge.v)) {
                    heap.update(edge.v, distance.get(curr) + edge.w);
                    parent.put(edge.v, curr);
                }
            }
        }
        return distance;
    }
}