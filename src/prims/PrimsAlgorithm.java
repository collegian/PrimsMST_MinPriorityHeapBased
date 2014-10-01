package prims;

import graph.Graph;
import graph.components.Edge;
import graph.components.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Prims Algorithm based on the greedy approach. In this all vertices are assigned keys and parents depending on the 
 * least weight edge incident upon them. All the vertices are stored in a minimum priority heap. The minimum spanning tree
 * is obtained without taking the root element (the first element taken out from the min-priority heap).
 * @author Rahul
 */
public final class PrimsAlgorithm 
{
    public Set<Edge> getMinimumSpanningTree(Graph graph)
    {
    	Set<Vertex> vertices = graph.getVertices();
    	for(Vertex vertex :vertices)
    	{
    		MinPriorityHeap.insertVertex(vertex);
    	}
    	
    	HashMap<Vertex,List<Vertex>> graphAdjacencyList = graph.getAdjacencyList();
    	
    	while(!MinPriorityHeap.getConstructedHeap().isEmpty())
    	{
    	   Vertex root = MinPriorityHeap.extractMinimumVertex();
    	   
    	   List<Vertex> rootAdjacencyList = graphAdjacencyList.get(root);
    	
    	   List<Vertex> currentHeapElements = MinPriorityHeap.getConstructedHeap();
    	   Set<Edge> edges = graph.getEdges();
    	   
    	   for(Vertex adjacentVertex : rootAdjacencyList)
    	   {
    		  Set<Edge> currentEdge = edges.stream().filter(e->((e.getStartVertex().equals(adjacentVertex) && e.getEndVertex().equals(root)) || (e.getStartVertex().equals(root) && e.getEndVertex().equals(adjacentVertex)))).collect(Collectors.toSet());
    		  verifyEdgeExistence(root,adjacentVertex,currentEdge);
    			
    		    int rootToAdjacentEdgeWeight = currentEdge.iterator().next().getWeight();
    			if(currentHeapElements.contains(adjacentVertex) && rootToAdjacentEdgeWeight < adjacentVertex.getKey())
    		    {
    			     adjacentVertex.setParent(root);
    			     adjacentVertex.setKey(rootToAdjacentEdgeWeight);
    			     
    			     //TODO: This is a bad way of doing things!
    			     currentHeapElements.remove(adjacentVertex);
    			     MinPriorityHeap.index--;
    			     MinPriorityHeap.insertVertex(adjacentVertex);
    		    }
    	    }
    	}
    	
    	return constructMST(graph);
    }
    
    private void verifyEdgeExistence(Vertex root,Vertex adjacentVertex,Set<Edge> currentEdge)
    {
    	 if(currentEdge==null || currentEdge.isEmpty())
			{
				throw new IllegalStateException("Couldn't find an edge between the root:" + root.getName() + " and the current adjacent vertex:" + adjacentVertex.getName());
			}
			
			if(currentEdge.size()>1)
			{
				throw new IllegalStateException("There are more than 1 edges between the root:" + root.getName() + " and the current adjacent vertex:" + adjacentVertex.getName());
			}
    }
    
    private Set<Edge> constructMST(Graph graph)
    {
    	Set<Edge> mstEdges = new HashSet<>();
    	for(Vertex vertex : graph.getVertices())
    	{
    		// The MST must be {v,v.pi without taking the root element}
    		if(vertex.getParent()!=null)
    		{
    	     	mstEdges.add(Edge.createEdge(vertex, vertex.getParent(),vertex.getKey()));
    		}
    	}	
    	
    	return mstEdges;
    }
}
