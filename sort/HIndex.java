package sort;

import java.util.*;

class HIndex {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;

        for (int i = citations.length - 1; i > -1; i--) {
            int min = (int)Math.min(citations[i], citations.length - i);
            if (max < min) max = min;
        }
        return max;
    }

    public int solution2(int[] citations) {
        int answer = 0;

        // n = total citations
        int n = citations.length;
        int h = n / 2;

        // int h = answer
        // int i = 0 ~ n - 1
        // citations[i] >= h && count(i) >= h
        // citations[i of rest] <= h 
        // input = 3, 0, 6, 1, 5
        // output = 3

        Arrays.sort(citations);
        // int hCount = 0;
        int k = 0;

        for (int i = 0; i < n; i++) {
           
            h = citations[i];
            k = n - i;

            System.out.println("i=" + i + ", h=" + h + ", k=" + k + ", citations[i]=" + citations[i]);

            if (k <= h) {
                answer = k;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println("Hel");
        HIndex h = new HIndex();
        int[] citations = {3, 0, 6, 1, 5};

        int a = h.solution(citations);
        System.out.println(a);
    }
}