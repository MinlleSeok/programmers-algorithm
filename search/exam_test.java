class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] person1 = new int[]{1, 2, 3, 4, 5};
        int[] person2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            answer1 = person1[i % person1.length] == answers[i] ? answer1 + 1 : answer1;
            answer2 = person2[i % person2.length] == answers[i] ? answer2 + 1 : answer2;
            answer3 = person3[i % person3.length] == answers[i] ? answer3 + 1 : answer3;
        }
        
        // System.out.println("answer1="+answer1+"answer2="+answer2+"answer3="+answer3);
      
        if (answer1 > answer2 && answer1 > answer3)
            return new int[]{1};
        if (answer2 > answer1 && answer2 > answer3)
            return new int[]{2};
        if (answer3 > answer1 && answer3 > answer2)
            return new int[]{3};
        
        if (answer1 == answer2 && answer1 > answer3)
            return new int[]{1, 2};
        if (answer3 == answer1 && answer3 > answer2)
            return new int[]{1, 3};
        if (answer2 == answer3 && answer3 > answer1)
            return new int[]{2, 3};
        
        if (answer1 == answer2 && answer1 == answer3)
            return new int[]{1, 2, 3};
        
        // if (answer2 == answer1 && answer2 > answer3)
        //     answer = new int[]{1, 2};
        
        // if (answer1 == 0 && answer2 == 0 && answer3 == 0)
        //     answer = new int[]{1, 2, 3};
        // if (answer2 == answer1 && answer2 == answer3)
        //     answer = new int[]{1, 2, 3};
        // if (answer3 == answer1 && answer3 == answer2)
        //     answer = new int[]{1, 2, 3};
        
        return answer;
    }
}