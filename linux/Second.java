package linux;

import java.util.*;

class Second {

    public boolean solution(int[] arr, int n) {
        boolean answer = false;

        HashSet <Integer> checker = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (checker.contains(arr[i])) {
                answer = true;
                break;
            } else {
                checker.add(n - arr[i]);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Second a = new Second();
        boolean b = a.solution(new int[]{5,3,9,13}, 8);
        System.out.println("bool=" + b);
    }
}