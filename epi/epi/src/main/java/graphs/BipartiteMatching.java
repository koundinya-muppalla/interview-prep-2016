package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import graphs.Graph.Vertex;

public class BipartiteMatching {

    public static boolean isBipartite(Graph g) {
        Map<Vertex, Integer> color = new HashMap<Graph.Vertex, Integer>();

        for(Vertex v : g.allVertex.values()) {
            color.put(v, -1);
        }


        for(Vertex v : g.allVertex.values()) {
            if(color.get(v) == -1) {
                if(!isBipartite(g, color, v)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isBipartite(Graph g, Map<Vertex, Integer> color, Vertex source) {
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.offer(source);
        color.put(source, 1);

        while(!queue.isEmpty()) {
            Vertex curr = queue.poll();

            for(Vertex adj : curr.neighbors) {
                if(color.get(adj) == -1) {
                    color.put(adj, color.get(curr) == 1 ? 0 : 1);
                    queue.offer(adj);
                } else if (color.get(adj) == color.get(curr)) {
                    return false;
                }
            }
        }
        return true;
    }
}
