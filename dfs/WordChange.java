package dfs;

import java.util.*;

class WordChange {

    static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public static int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;

        Queue<Node> q = new LinkedList<>();

        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i = 0; i < n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }
        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i = 0; i < n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++cnt > 1) return false;
            }
        }
        return true;
    }

    static boolean[] v;

    public int dfs(String begin, String target, String[] words) {
        int answer = 0;
        String dupBegin;

        // check each item in words array
        for (int i = 0; i < words.length; i++) {
            // already visited
            if (v[i]) { continue; }

            // check each character
            for (int j = 0; j < begin.length(); j++) {
                
                // duplicated
                dupBegin = begin;
                dupBegin = (j > 0 ? begin.substring(0, j): "")
                         + words[i].charAt(j)
                         + (j < begin.length() - 1 ? begin.substring(j + 1) : "");

                if (dupBegin.equals(target)) { return 1; }
                
                if (dupBegin.equals(words[i])) {
                    v[i] = true;
                    answer = 1;
                    answer += dfs(dupBegin, target, words);
                }
            }
        }
        return answer;
    }
    
    public int solution2(String begin, String target, String[] words) {
        v = new boolean[words.length + 1];

        for (int i = 0; i < words.length; i++) {
           if (target.equals(words[i])) { return dfs(begin, target, words); }
        }        
        
        return 0;
    }

    public static void main(String[] args) {
        solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }

}
