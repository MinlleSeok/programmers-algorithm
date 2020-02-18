package greedy;

import java.util.Arrays;

class Camera {
    public int solution(int[][] routes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        for (int[] route : routes) {
            if (min < route[0]) {
                min = route[1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Camera c = new Camera();
        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int res = c.solution(routes);
        System.out.println("res=" + res + ", assertion=" + (res == 2));
    }
}