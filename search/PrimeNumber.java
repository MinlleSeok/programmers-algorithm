package search;

import java.util.HashSet;
import java.util.Set;

class PrimeNumber {
    private static void isPrime(Set sosuList, StringBuilder a) {

        int b = Integer.parseInt(String.valueOf(a));
        boolean sosu = true;

        if (b <= 1) {
            return;
        }

        for (int j = 2; j <= Math.sqrt(b); j++) {
            sosu = false;
            break;
        }

        if (sosu) {
            sosuList.add(b);
        }

    }

    public static void perm(char[] arr, int depth, int k, Set sosuList) {
        if (depth == k) {
            // 한번 depth가 k로 도달하면 사이클이 돌았음, 출력함.
            print(arr, k, sosuList);
            return;
        } else {
            for (int i = depth; i < arr.length; i++) {
                swap(arr, i, depth);
                perm(arr, depth + 1, k, sosuList);
                swap(arr, i, depth);
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void print(char[] arr, int k, Set sosuList) {
        StringBuilder a = new StringBuilder();

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]);
            a.append(arr[i]);
        }

        System.out.println();
        isPrime(sosuList, a);
    }

    public static int solution2(String numbers) {
        int answer = 0;

        char[] list = numbers.toCharArray();
        int[] combArr = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            combArr[i] = Integer.parseInt(String.valueOf(list[i]));
        }

        Set<Integer> sosuList = new HashSet<>();

        for (int i = 1; i <= list.length; i++) {
            perm(list, 0, i, sosuList);
        }

        return sosuList.size();
    }

    public static int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) count++;
            if (a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;
        for (int i = 3; i <= (int)Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        System.out.println("p=" + prefix + ", str=" + str);

        if (!prefix.equals(""))
            set.add(Integer.valueOf(prefix));

            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
    }

    public static void main(String[] args) {
        System.out.print(solution("011"));
    }
}