package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import graph.Graph;
import graph.components.Edge;
import graph.components.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import prims.PrimsAlgorithm;

public final class PrimsOperationsTest 
{
	  PrimsAlgorithm pa = new PrimsAlgorithm();
	  Graph graph;
	  Set<Edge> expectedEdges;
	  
	  @Before
	  public void setUp()
	  {
		  Vertex a = Vertex.createVertex('a');
		  Vertex b = Vertex.createVertex('b');
		  Vertex c = Vertex.createVertex('c');
		  Vertex d = Vertex.createVertex('d');
		  Vertex e = Vertex.createVertex('e');
		  Vertex f = Vertex.createVertex('f');
		  Vertex g = Vertex.createVertex('g');
		  Vertex h = Vertex.createVertex('h');
		  Vertex i = Vertex.createVertex('i');
		  
		  Set<Vertex> vertices = new HashSet<>();
		  vertices.add(a);
		  vertices.add(b);
		  vertices.add(c);
		  vertices.add(d);
		  vertices.add(e);
		  vertices.add(f);
		  vertices.add(g);
		  vertices.add(h);
		  vertices.add(i);
		  
		  Set<Edge> edges = new HashSet<>();
		  
		  Edge ab = Edge.createEdge(a, b, 4);
		  Edge ah = Edge.createEdge(a, h, 8);
		  Edge bh = Edge.createEdge(b, h, 11);
		  Edge bc = Edge.createEdge(b, c, 8);
		  Edge hi = Edge.createEdge(h, i, 7);
		  Edge hg = Edge.createEdge(h, g, 1);
		  Edge gi = Edge.createEdge(g, i, 6);
		  Edge gf = Edge.createEdge(g, f, 2);
		  Edge ci = Edge.createEdge(c, i, 2);
		  Edge cf = Edge.createEdge(c, f, 4);
		  Edge cd = Edge.createEdge(c, d, 7);
		  Edge de = Edge.createEdge(d, e, 9);
		  Edge ef = Edge.createEdge(e, f, 10);
		  Edge df = Edge.createEdge(d, f, 14);
		  
		  
		  edges.add(ab);
		  edges.add(ah);
		  edges.add(bh);
		  edges.add(bc);
		  edges.add(hi);
		  edges.add(hg);
		  edges.add(gi);
		  edges.add(gf);
		  edges.add(ci);
		  edges.add(cf);
		  edges.add(cd);
		  edges.add(de);
		  edges.add(ef);
		  edges.add(df);
		  
		  HashMap<Vertex,List<Vertex>> adjacentVerticesForEachVertex = new HashMap<>(vertices.size());
		  
		  List<Vertex> adjVertexA = Lists.newArrayList(b,h);
		  adjacentVerticesForEachVertex.put(a, adjVertexA);
		  
		  List<Vertex> adjVertexB = Lists.newArrayList(a,h,c);
		  adjacentVerticesForEachVertex.put(b, adjVertexB);
		  
		  List<Vertex> adjVertexC = Lists.newArrayList(b,d,i,f);
		  adjacentVerticesForEachVertex.put(c, adjVertexC);
		  
		  List<Vertex> adjVertexD = Lists.newArrayList(c,e,f);
		  adjacentVerticesForEachVertex.put(d, adjVertexD);
		  
		  List<Vertex> adjVertexE = Lists.newArrayList(d,f);
		  adjacentVerticesForEachVertex.put(e, adjVertexE);
		  
		  List<Vertex> adjVertexF = Lists.newArrayList(c,d,e);
		  adjacentVerticesForEachVertex.put(f, adjVertexF);
		  
		  List<Vertex> adjVertexG = Lists.newArrayList(h,i,f);
		  adjacentVerticesForEachVertex.put(g, adjVertexG);
		  
		  List<Vertex> adjVertexH = Lists.newArrayList(a,b,i,g);
		  adjacentVerticesForEachVertex.put(h, adjVertexH);
		  
		  List<Vertex> adjVertexI = Lists.newArrayList(h,g,c);
		  adjacentVerticesForEachVertex.put(i, adjVertexI);
		  
		  expectedEdges = new HashSet<>();
		  expectedEdges.add(hg);
		  expectedEdges.add(gf);
		  expectedEdges.add(ci);
		  expectedEdges.add(ab);
		  expectedEdges.add(cf);
		  expectedEdges.add(cd);
		  expectedEdges.add(ah);
		  expectedEdges.add(bc);
		  expectedEdges.add(hi);
		  expectedEdges.add(de);
		  
	      graph = Graph.createGraph(vertices, edges,adjacentVerticesForEachVertex);
	  }
	  
	  @Test
	  public void testPrimsAlgorithm()
	  {
		Set<Edge> mst = pa.getMinimumSpanningTree(graph);
		for(Edge edge:mst)
		{
			System.out.println(edge.getStartVertex().getName() + "->" + edge.getEndVertex().getName());
		}
		//assertEquals("mst:expected size!=actual size", 8, mst.size());
		//assertTrue(expectedEdges.containsAll(mst));
	  }
}
