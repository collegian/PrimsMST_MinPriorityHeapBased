package graph;

import graph.components.Edge;
import graph.components.Vertex;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

//TODO : Do we need equals/hashcode?
public final class Graph 
{
   private Set<Vertex> vertices;
   private Set<Edge> edges;
   
   //Using a hashmap instead of adjacency list to store adjacent vertices corresponding to each vertex.
   //TODO: Check performance impact + using Set<Vertex> as values instead of List.
   private HashMap<Vertex,List<Vertex>> adjacentVerticesForEachVertex;
   
   public static Graph createGraph(Set<Vertex> vertices,Set<Edge> edges,HashMap<Vertex,List<Vertex>> adjacentVerticesForEachVertex)
   {
	   Graph graph = new Graph(vertices,edges,adjacentVerticesForEachVertex);
	   return graph;
   }
   
   private Graph(Set<Vertex> vertices,Set<Edge> edges,HashMap<Vertex,List<Vertex>> adjacentVerticesForEachVertex)
   {
	   this.vertices=vertices;
	   this.edges =edges;
	   this.adjacentVerticesForEachVertex = adjacentVerticesForEachVertex;
   }
   
   // May be null.
   public Set<Vertex> getVertices()
   {
	   return vertices;
   }
   
// May be null.
   public Set<Edge> getEdges()
   {
	   return edges;
   }
   
   public HashMap<Vertex,List<Vertex>> getAdjacencyList()
   {
	   return adjacentVerticesForEachVertex;
   }
}
