package prims;

import graph.components.Vertex;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

// Used to store vertices in a min priority based heap.
// If root is stored at index 'i' then left is stored at '2i' and right at '2i+1'.
// Since the indices start at 0, the left and right are 2i+1 and 2i+2 respectively.
//TODO: Still debating if static methods are better than instance methods here?
// Static methods are a bad idea since that would allow any one to potentially call it 
// and change the state of the data structure when we don't want it.
public final class MinPriorityHeap 
{
   private static List<Vertex> minHeapOfVertices = Lists.newArrayListWithCapacity(14);
   public static int index = 0;
   
   public static void insertVertex(Vertex vertex)
   {
	   // If the heap already has elements then the heap property needs to be maintained.
	   if(index>0)
	   {
		   //TODO: Is there a better way of getting the parent?
		   double division = (double) index/2;
		   double ceilValue = Math.ceil(division);
		   
		   int parent = (int) ceilValue-1;
		   
		   Vertex parentVertex=minHeapOfVertices.get(parent);
		   
		   if(parentVertex==null)
		   {
			   throw new IllegalStateException("Parent vertex of index:" + index + " is null");
		   }
		   
		   if(vertex.getKey() >= parentVertex.getKey())
		   {
			   minHeapOfVertices.add(index++, vertex);
		   }
		   else
		   {
			   //Maintain min heap property that smallest element is at the root.
			   // Keep comparing with the parent and swapping until it reaches the right position.
			   minHeapOfVertices.add(index++,vertex);
			   maintainHeapProperty(vertex,index-1);
		   }
	   }
	   else
	   {
		   minHeapOfVertices.add(index++,vertex);
	   }
   }
   
   public static List<Vertex> getConstructedHeap()
   {
	   return minHeapOfVertices;
   }
   
   private static void maintainHeapProperty(Vertex vertex,int newVertexIndex)
   {
	   if(newVertexIndex==0)
	   {
		   return;
	   }
	   
	   double div = (double) newVertexIndex/2;
	   
	   int parentVertexIndex = (int) Math.ceil(div) - 1;
	   
	   Vertex parentVertex = minHeapOfVertices.get(parentVertexIndex);
	   
	   if(vertex.getKey()<parentVertex.getKey())
	   {
		   //TODO : See if this call can be simplified!
		   swap(parentVertexIndex,newVertexIndex,parentVertex,vertex);
		   maintainHeapProperty(vertex,parentVertexIndex);
	   }
   }
   
   private static void swap(int parentVertexIndex,int newVertexIndex,Vertex parentVertex, Vertex newVertex)
   {
	   minHeapOfVertices.remove(parentVertexIndex);
	   minHeapOfVertices.add(parentVertexIndex, newVertex);
	   

	   minHeapOfVertices.remove(newVertexIndex);
	   minHeapOfVertices.add(newVertexIndex,parentVertex);
   }
   
   public static Vertex extractMinimumVertex()
   {
	  Vertex root = minHeapOfVertices.remove(0);
	  if(root==null)
	  {
		  throw new IllegalStateException("There are no elements in the heap to retrieve, please insert some before attempting to retrieve");
	  }
	  
	  if(index-2<0)
	  {
		  return root;
	  }
	  
	  
	  // Remove the last element and place at the root. 
	  // The remove operation above shifts elements left by one position.
	  Vertex lastVertex = minHeapOfVertices.remove(index-2);
	  if(lastVertex==null)
	  {
		  throw new IllegalStateException("last vertex:null");
	  }
	  minHeapOfVertices.add(0,lastVertex);
	  sinkDown(lastVertex,0);
	  index--;
	  
	  return root;
   }
   
   // sinksDown the last replaced vertex to it's correct index in the tree.
   private static void sinkDown(Vertex currentRoot,int index)
   {
	   if(2*index+2 > minHeapOfVertices.size())
	   {
		   return;
	   }
	   
	  Vertex leftChild = minHeapOfVertices.get(2*index+1);
	  Vertex rightChild = null;
	  
	  // As per the heap property that the heap is always balanced except for the last level.
	  if(2*index+2!=minHeapOfVertices.size())
	  {
	     rightChild = minHeapOfVertices.get(2*index+2);
	  }
	  
	  if(leftChild==null)
	  {
		  return;
	  }
	  
	  if(rightChild==null)
	  {
		  if(leftChild.getKey()<currentRoot.getKey())
		  {
			  minHeapOfVertices.remove(index);
			  minHeapOfVertices.add(index, leftChild);
			
			  minHeapOfVertices.remove(2*index+1);
			  minHeapOfVertices.add(2*index+1,currentRoot);
		  }
		  
		  return;
	  }
	  
	  if(leftChild.getKey() <= rightChild.getKey())
	  {
		  minHeapOfVertices.remove(index);
		  minHeapOfVertices.add(index, leftChild);
		  
		  minHeapOfVertices.remove(2*index+1);
		  minHeapOfVertices.add(2*index+1,currentRoot);
		  
		  sinkDown(currentRoot,2*index+1);
	  }
	  else
	  {
		  minHeapOfVertices.remove(index);
		  minHeapOfVertices.add(index, rightChild);
		  
		  minHeapOfVertices.remove(2*index+2);
		  minHeapOfVertices.add(2*index+2,currentRoot);
		  sinkDown(currentRoot,2*index+2);
	  }
   }
}
