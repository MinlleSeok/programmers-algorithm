package linux;

import java.util.*;
import java.util.regex.Pattern;

class Third {

    public void solve(String str, int N, int arr[]) {
        int len = 0;
        int i;
        
        arr[0] = 0;
        i = 1;
        
        while (i < N) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                arr[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = arr[len - 1];
                } else {
                    arr[i] = 0;
                    i++;
                }
            }
        }
    }
    public int solution(String s) {
        int answer = 1;
        
        int n = s.length();
        int arr[] = new int[n];
        
        solve(s, n, arr);
        
        int len = arr[n - 1];
        
        answer = len > 0 && n % (n - len) == 0 ? n - len : n;
        
        return answer;
    }

    public int solution2(String s) {
        int answer = 1;
        // StringBuilder str = new StringBuilder(s);

        for (int i = answer; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            System.out.println("sub=" + sub);
            String reg = "^("+ sub + ")+$";
            boolean flag = false;

            for (int j = 0; j < s.length(); j+= i) {

                String z = s.substring(j, j + i > s.length() ? s.length() : j + i);
                System.out.println(z);
                if (!sub.equals(z)) {
                    flag = true;
                    break;
                }
            }
             if(!flag) {
                 answer = i;
                 break;
             }
           

        }
        return answer;
    }

    //     public int solution2(String s) {
//         int answer = 1;
//         // StringBuilder str = new StringBuilder(s);

//         for (int i = answer; i <= s.length(); i++) {
//             String sub = s.substring(0, i);
//             // System.out.println("sub=" + sub);
//             String reg = "^("+ sub + ")+$";
//             // System.out.println(Pattern.matches(reg, str));
//             if (s.matches(reg)) {
//                 answer = i;
//                 break;
//             }

//         }
//         return answer;
//     }

            static void computeLPSArray(String str, int M, int lps[]) {
                int len = 0;
                int i;

                lps[0] = 0;
                i = 1;

                while (i < M) {
                    if (str.charAt(i) == str.charAt(len)) {
                        len++;
                        lps[i] = len;
                        i++;
                    } else {
                        if (len != 0) {
                            len = lps[len - 1];
                        } else {
                            lps[i] = 0;
                            i++;
                        }
                    }
                }
            }
    static int isRepeat(String str) {
        int n = str.length();
        int lps[] = new int[n];

        computeLPSArray(str, n, lps);

        int len = lps[n - 1];
        for (int i = 0; i < lps.length; i++)
            System.out.println(lps[i]);

        return (len > 0 && n % (n - len) == 0) ? n - len : n;

    }
    public static void main(String[] args) {
        Third a = new Third();
        int b = a.solution("abaaba");
        System.out.println("result=" + b);
        System.out.println(isRepeat("abaabaaba"));
    }
}