// package graph;

// import java.util.*;

// class Rank {
//     public int solution(int n, int[][] results) {
//         Graph graph = new Graph(n, results);
//         int result = 0;

//         for (int i = 0; i < n; i++) {
//             if (graph.bfs(i)) {
//                 result++;
//             }
//             graph.initVisits();
//         }
//         return result;
//     }

//     class Graph {
//         Node[] nodes;

//         public Graph(int n, int[][] results) {
//             nodes = new Node[n];

//             for (int i = 0; i < n; i++) {
//                 nodes[i] = new Node(i + 1);
//             }
            
//             for (int i = 0; i < results.length; i++) {
//                 addEdge(results[i][0] - 1, results[i][1] - 1);
//             }
//         }

//         public void addEdge(int winner, int loser) {
//             if (!nodes[winner].losers.contains(nodes[loser])) {
//                 nodes[winner].losers.add(nodes[loser]);
//             }

//             if (!nodes[loser].winners.contains(nodes[winner])) {
//                 nodes[loser].winners.add(nodes[winner]);
//             }
//         }

//         private void initVisits() {
//             for (Node node : nodes) {
//                 node.visit = false;
//             }
//         }

//         public boolean bfs(int n) {
//             return bfs(nodes[n]);
//         }

//         public boolean bfs(Node node) {
//             Queue<Node> queue = new LinkedList<>();
//             queue.add(node);
//             node.visit = true;

//             int winnerCount = searchWinner(node, 0, (Node n) -> n.winners);
//             int loserCount = searchWinner(node, 0, (Node n) -> n.losers);

//             return winnerCount + loserCount == nodes.length - 1;
//         }

//         private int searchWinner(Node node, int count, Function<Node, List<Node>> func) {
//             for (Node n : func.apply(node)) {
//                 if (!n.visit) {
//                     n.visit = true;
//                     count += searchWinner(n, 1, func);
//                 }
//             }
//             return count;
//         }

//         private boolean isRanked() {
//             for (Node node : nodes) {
//                 if (!node.visit) return false;
//             }
//             return true;
//         }

//         class Node {
//             int data;
//             boolean visit;
//             List<Node> winners;
//             List<Node> losers;

//             public Node(int data) {
//                 this.data = data;
//                 this.winners = new LinkedList<>();
//                 this.losers = new LinkedList<>();
//             }

//             @Override
//             public String toString() {
//                 return "Node{" +
//                         "data=" + data +
//                         ", visit=" + visit +
//                         '}';
//             }
//         }
//     }
// }