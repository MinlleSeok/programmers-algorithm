package dfs;

class TargetNumber {

    public static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public static void dfs(int[] numbers, int n, int sum, int target) {
        
        // base case
        if (n == numbers.length) {

            // answer case
            if (sum == target) {
                answer++;
                return;
            }

            // exit case
            return;
        }

        // recursive
        dfs(numbers, n + 1, sum + numbers[n], target);
        dfs(numbers, n + 1, sum - numbers[n], target);
    }

    public static int solution2(int[] numbers, int target) {
        int answer2 = 0;
        answer2 = dfs2(numbers, 0, 0, target);
        return answer2;
    }

    public static int dfs2(int[] numbers, int n, int sum, int target) {
        // System.out.println("n="+n+",sum="+sum+",target="+target);
        if (n == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs2(numbers, n + 1, sum + numbers[n], target)
             + dfs2(numbers, n + 1, sum - numbers[n], target);
    }

    public static int solution3(int[] numbers, int target) {
        int answer = 0;
        Node node = new Node(0);    // initial value 0
        
        for (int i = 0; i < numbers.length; i++) {
            node.setNode(node, numbers[i]);
        }

        answer = node.countValue(node, target);

        return answer;
    }

    static class Node {
        private int value;
        private Node rightNode; // + node
        private Node leftNode;  // - node
        
        public Node() {
            value = 0;
        }

        public Node(int value) {
            this.value = value;
            this.rightNode = null;
            this.leftNode = null;
        }

        /*
            set next depth node
            if current == leaf node => set next node
        */
        public void setNode(Node node, int val) {
            if (!node.isTerminal()) {
                setNode(node.leftNode, val);
                setNode(node.rightNode, val);
            } else {
                node.rightNode = new Node(node.getValue() + val);
                node.leftNode = new Node(node.getValue() - val);
            }
        }

        public boolean isTerminal() {
            return this.rightNode == null && this.leftNode == null ? true : false;
        }

        public int countValue(Node node, int value) {
            // int cnt = 0;

            if (!node.isTerminal()) {
                return countValue(node.leftNode, value) + countValue(node.rightNode, value);
            } else {
                if (node.getValue() == value) {
                    return 1;
                }
            }
            return 0;
        }

        public void searchNode(Node node) {

        }

        public int getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        solution(new int[]{1,1,1,1,1}, 2);
        System.out.println(answer);

        int answer2 = solution2(new int[]{1,1,1,1,1}, 2);
        System.out.println(answer2);
    }
}