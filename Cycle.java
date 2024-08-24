 import java.util.*;
 public class Cycle{
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i =0 ; i<graph.length;i++){
            graph[i]= new ArrayList<Edge>();
        }
        graph [0].add(new Edge(0, 2));
        graph [1].add(new Edge(1, 0));
        graph [2].add(new Edge(2, 3));
        graph [3].add(new Edge(3, 0));
   
    }
    //O(E+V)
    public static boolean isCycleDirected(ArrayList<Edge>graph[],boolean vis[],int curr,boolean rec[]){
      vis[curr]=true;
      rec[curr]=true;
      for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if (rec[e.dest]==true) {
            return true;
            
        }
        else if(!vis[e.dest]){
            if(isCycleDirected(graph, vis, e.dest, rec)){
                return true;//mtlb agr us neighbour k wahan pr cycle exist karte ho ge tu b tu humare graph k ander cycle exist karte hai tu agr second call ne true return kar dia tu humein b return karna hai true 
            }
        }
      }
      rec[curr]=false;//jate jate stack se hata do 
      return false;

    }
    public static void main(String[] args) {
       int V=4 ;
       ArrayList<Edge> graph[] = new ArrayList[V];
createGraph(graph);
boolean vis[ ] = new boolean[V];
boolean rec[ ] = new boolean[V];
for (int i = 0; i < V; i++) {
    if(!vis[i]){
boolean isCycle = isCycleDirected(graph, vis, 0, rec);//sgr akela syso kre ge tu agr ek tokre se ni mil paya tu wo false he return kre ga tu neechay if lagaya h
if(isCycle){//kyo k humein bs ek he cycle chahiyay hote hai mutiple cycle nai chahiyay hote


    System.out.println(isCycle);
    break;
}
    }

}
    }
}