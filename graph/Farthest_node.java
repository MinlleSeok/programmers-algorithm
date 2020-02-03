package graph;

import java.util.*;

class Farthest_node {

    public static int solution(int n, int[][] edge) {
        ArrayList<Integer>[] path = new ArrayList[n];
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        int answer = 0;
        int[] dist = new int[n];
        dist[0] = 1;
        int max = 0;

        for (int i = 0; i < edge.length; i++) {
            int num1 = edge[i][0] - 1;
            int num2 = edge[i][1] - 1;

            if(path[num1] == null)
                path[num1] = new ArrayList<Integer>();
            if(path[num2] == null)
                path[num2] = new ArrayList<Integer>();
            path[num1].add(num2);
            path[num2].add(num1);
        }

        bfs.add(0);
        while(!bfs.isEmpty()) {
            int idx = bfs.get(0);
            bfs.remove(0);

            while(!path[idx].isEmpty()) {
                int num = path[idx].get(0);
                path[idx].remove(0);
                bfs.add(num);

                if(dist[num] == 0) {
                    dist[num] = dist[idx] + 1;
                    max = dist[num];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == max)
                answer++;
        }
        
        return answer;
    }

    public static int solution2(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        boolean[][] connect = new boolean[n + 1][n + 1];

        for (int i = 0; i < edge.length; i++) {
            int left = edge[i][0];
            int right = edge[i][1];
            connect[left][right] = connect[right][left] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> nextNodes = new ArrayList<>();

        queue.add(1);
        visited[0] = visited[1] = true;
        
        while(true) {
            answer = queue.size();

            while(!queue.isEmpty()) {
                int node = queue.poll();
                for (int j = 1; j <= n; j++) {
                    if(!visited[j] && connect[node][j]) {
                        nextNodes.add(j);
                        visited[j] = true;
                    }
                }
            }
            if(nextNodes.isEmpty()) {
                break;
            }
            queue.addAll(nextNodes);
            nextNodes.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        int [][] a = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6, a));
        
    }
}