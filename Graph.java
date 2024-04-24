package code.jogger.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int V ; 
    ArrayList<Integer>[]adj;
    public Graph(int V)
    {
     this.V = V;
     adj = new ArrayList[V];
     for(int i=0; i<V; i++)
    	 adj[i] = new ArrayList<>();
     
    }
    
    public void addEdge(int u, int v)
    {
     adj[u].add(v);
     adj[v].add(u);
    }
    
    // display Adjacency
    public void displayAdj()
    {
     for(int i=0; i<V; i++)
     {
      for(int x : adj[i])
      {
    	  System.out.print(x+" ");
      }
      System.out.println();
     }
    }
    
   public void BFS(boolean vis[])
   {
	 for(int i=0; i<V; i++)
	 {
	   if(!vis[i])
		   bfsUtil(i, vis);
	 }
   }
   
   public void bfsUtil(int src, boolean vis[])
   {   
	Queue<Integer>q = new LinkedList<Integer>(); 
	q.add(src);
	vis[src] = true; 
	
	while(!q.isEmpty())
	{		
      int temp = q.poll();
      System.out.print(temp+" ");
      for(int x : adj[temp])
      {
    	if(!vis[x])
    	{
         q.add(x);
         vis[x]=true;
    	}
      }
	}
   }
    
   public void dfsUtil(int src, boolean vis[])
   {
	System.out.print(src+" ");
	vis[src]=true;
	for(int x : adj[src])
	{
	 if(!vis[x])
	 dfsUtil(x, vis);
	}
   }
   
   public void DFS(boolean vis[])
   {
	for(int i=0; i<V; i++)
	{
      if(!vis[i])
    	  dfsUtil(i, vis);
	}
   }
    
   
	public static void main(String[] args) {
	Graph graph = new Graph(5);
	// add egdes
	graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(1, 4);
 
    
    boolean vis[] = new boolean[5];
    graph.DFS(vis);
	}

}
