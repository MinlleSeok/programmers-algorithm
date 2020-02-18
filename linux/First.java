package linux;

class First {

    public int solution(int n) {
        int answer = 3;
        String str = Integer.toString(n);
        // System.out.println(str);
        // int leng = str.length();

        while (str.length() > 1) {
            int result = 0;
            for (int i = 0; i < str.length(); i++) {
                result += str.charAt(i) - '0';
                System.out.println(result);
            }
            
            str = Integer.toString(result);
            System.out.println(str);
        }
        
        answer = Integer.parseInt(str);
        System.out.println(answer);

        return answer;
    }
    public static void main(String[] args) {
        First a = new First();
        int b = a.solution(34);
        System.out.print(b);
    }
}