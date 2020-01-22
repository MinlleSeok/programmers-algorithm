package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

class N_expression {

    public static int solution(int N, int number) {
        int answer = -1;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> s = new HashSet<>();

        // add into set
        s.add(N);

        // add into map
        map.put(1, s);

        loop : for (int i = 2; i < 9; i++) {

            // inner set
            HashSet<Integer> set = new LinkedHashSet<>();

            // NN, NNN, NNNN, ...
            int NNN = Integer.parseInt(Integer.toBinaryString((int) Math.pow(2, i) - 1)) * N;

            // if result
            if (NNN == number) {
                return i;
            }

            // add into inner set
            set.add(NNN);

            // for
            for (int j = 1; j <= i / 2; j++) {

                // iterator 2 values
                Iterator<Integer> it1 = map.get(j).iterator();
                Iterator<Integer> it2 = map.get(i - j).iterator();

                // iterate
                while (it1.hasNext()) {
                    int itValue1 = it1.next();

                    while (it2.hasNext()) {
                        int itValue2 = it2.next();
                        
                        // for - Operator
                        for (Operator o : Operator.values()) {

                            // calculate
                            int calculate = o.calculate(itValue1, itValue2);

                            // if result
                            if (calculate == number) {
                                answer = i;
                                break loop;
                            }

                            // add into inner set
                            set.add(calculate);
                        }
                    }
                }
            }

            // add int map
            map.put(i, set);
        }

        return answer;
    }

    enum Operator {
        PLUS {
            @Override
            public int calculate(int i, int j) {
                return i + j;
            }
        }, MINUS {
            @Override
            public int calculate(int i, int j) {
                return i - j;
            }
        }, BACKMINUS {
            @Override
            public int calculate(int i, int j) {
                return j - i;
            }
        }, MUL {
            @Override
            public int calculate(int i, int j) {
                return i * j;
            }
        }, DIV {
            @Override
            public int calculate(int i, int j) {
                if (j == 0) {
                    return 0;
                }
                return i / j;
            }
        }, BACKDIV {
            @Override
            public int calculate(int i, int j) {
                if (i == 0) {
                    return 0;
                }
                return j / i;
            }
        };
        public abstract int calculate(int i, int j);
    }

    public static void main(String[] args) {
        System.out.println("hi");
        System.out.println(solution(5, 12));
    }
}