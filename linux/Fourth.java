package linux;

import java.util.*;

class Fourth {

    // Java Program to demonstrate adjacency list
    // representation of graphs

    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)


    // Adds an edge to an undirected graph
   

    // This code is contributed by Sumit Ghosh

    // static void solve(int[][] graph, int node, int k, int v, int e) {
    //     LinkedList<LinkedList<Integer>> tree = new LinkedList<>();

    //     for (int i = 0; i < e; i++) {
    //         int from = graph[i][0];
    //         int to = graph[i][1];

    //     }
    // }

    // public int[] solution(int N, int[][] relation) {
    //     int[] answer = { 0 };

    //     int edge = relation.length;

    //     int node = 4, k = 2;

    //     solve(relation, node, k, N, edge);

    //     return answer;
    // }


    static int[] result;
    
    static class Graph {

        int V;
        LinkedList<Integer> adj[];

        Graph(int V) {
            this.V = V;

            adj = new LinkedList[V];

            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }
    }
    
    public void addEdge(Graph graph, int src, int dest) {
        graph.adj[src].add(dest);
        graph.adj[dest].add(src);
    }
    
    public void calculate(Graph graph) {
        for (int v = 0; v < graph.V; v++) {
     
            for (Integer value : graph.adj[v]) {
                if(graph.adj[v].size() > 1){
                    result[value - 1]++;
                }
                result[v - 1]++;
            }
        }
    }
    
    public int[] solution(int N, int[][] relation) {
        int[] answer = {0};
        result = new int[N];
        Graph graph = new Graph(N + 1);
        
        for (int i = 0; i < relation.length; i++) {
            addEdge(graph, relation[i][0], relation[i][1]);
        }
    
        calculate(graph);
        
        answer = result;

        return answer;
    }
    public static void main(String[] args) {
        Fourth a = new Fourth();
        int[] c = a.solution(5, new int[][] { { 1, 2 }, { 4, 2 }, { 3, 1 }, { 4, 5 }});

        for(int x : c) {
            System.out.println(x);
        }
    }
}