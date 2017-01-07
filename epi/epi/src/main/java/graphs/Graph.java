package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Graph {
	Map<Integer, Vertex> allVertex;
	List<Edge> allEdges;
	int v, e;
	boolean isDirected;
	
	public Graph(boolean isDirected) {
		v = 0;
		e = 0;
		this.isDirected = isDirected;
		this.allEdges = new ArrayList<Graph.Edge>();
		this.allVertex = new HashMap<Integer, Graph.Vertex>();
	}
	
	public void addEdge(int u, int v) {
		Vertex v1 = null;
		if(allVertex.containsKey(u)) {
			v1 = allVertex.get(u);
		} else {
			v1 = new Vertex(u);
			allVertex.put(u, v1);
		}
		
		Vertex v2 = null;
		if(allVertex.containsKey(v)) {
			v2 = allVertex.get(v);
		} else {
			v2 = new Vertex(v);
			allVertex.put(v, v2);
		}
		
		Edge e = new Edge(v1, v2, isDirected);
		allEdges.add(e);
		v1.addAdjecentVertex(v2, e);
		if(!isDirected) {
			v2.addAdjecentVertex(v1, e);
		}
	}
	
	static class Vertex {
		int data;
		List<Vertex> neighbors;
		List<Edge> edges;
		
		public Vertex(int data) {
			this.data = data;
			this.neighbors = new ArrayList<Graph.Vertex>();
			this.edges = new ArrayList<Graph.Edge>();
		}
		
		public void addAdjecentVertex(Vertex v, Edge e) {
			this.neighbors.add(v);
			this.edges.add(e);
		}
	}
	
	static class Edge {
		Vertex u;
		Vertex v;
		int w;
		boolean weighted = false;
		boolean isDirected;
		
		public Edge(Vertex u, Vertex v, boolean isDirected) {
			this.u = u;
			this.v = v;
			this.w = 0;
			this.isDirected = isDirected;
		}
		
		public Edge(Vertex u, Vertex v, int w, boolean isDirected) {
			this.u = u;
			this.v = v;
			this.w = w;
			this.weighted = true;
			this.isDirected = isDirected;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o == null) {
				return false;
			}
			
			if(!(o instanceof Edge)) {
				return false;
			}
			
			Edge other = (Edge) o;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.u, other.u).append(this.v, other.v);
			return builder.isEquals();
		}
		
		@Override
		public int hashCode() {
			HashCodeBuilder builder = new HashCodeBuilder();
			builder.append(this.u);
			builder.append(this.v);
			return builder.hashCode();
		}
	}
}
