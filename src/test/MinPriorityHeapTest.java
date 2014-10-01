package test;

import java.util.List;

import graph.components.Vertex;

import org.junit.Test;

import prims.MinPriorityHeap;

public final class MinPriorityHeapTest 
{
	@Test
	   public void testHeapInsert()
	   {
		   Vertex a = Vertex.createVertex('a');
		   a.setKey(2);
		   
		   Vertex b = Vertex.createVertex('b');
		   b.setKey(1);
		   
		   Vertex c = Vertex.createVertex('c');
		   c.setKey(4);
		   
		   Vertex d = Vertex.createVertex('d');
		   d.setKey(7);
		   
		   Vertex e = Vertex.createVertex('e');
		   e.setKey(8);
		   
		   Vertex f = Vertex.createVertex('f');
		   f.setKey(3);
		   
		   Vertex g = Vertex.createVertex('g');
		   g.setKey(9);
		   
		   Vertex h = Vertex.createVertex('h');
		   h.setKey(16);
		   
		   Vertex i = Vertex.createVertex('i');
		   i.setKey(10);
		   
		   Vertex j = Vertex.createVertex('j');
		   j.setKey(14);
		   
		   Vertex k = Vertex.createVertex('k');
		   k.setKey(17);
		   
           MinPriorityHeap.insertVertex(a);
           MinPriorityHeap.insertVertex(b);
           MinPriorityHeap.insertVertex(c);
           MinPriorityHeap.insertVertex(d);
           MinPriorityHeap.insertVertex(e);
           MinPriorityHeap.insertVertex(f);
           MinPriorityHeap.insertVertex(g);
           MinPriorityHeap.insertVertex(h);
           MinPriorityHeap.insertVertex(i);
           MinPriorityHeap.insertVertex(j);
           MinPriorityHeap.insertVertex(k);
           
		 // printVertices();
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
		  
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
		  
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
		  
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
		  
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
		  
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
		  
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
		  
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
		  
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
		  
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
		  
		  System.out.println("The minimum key extracted is:" + MinPriorityHeap.extractMinimumVertex().getKey());
		  printVertices();
	   }
	
	private void printVertices()
	{
		 List<Vertex> vertices = MinPriorityHeap.getConstructedHeap();
		  for(Vertex vertex : vertices)
		  {
			  System.out.println(vertex.getKey());
		  }
	}
}
