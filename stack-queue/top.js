
function solution(heights) {
        var answer = [];
        
        // 1, 2, 3, 4, 5 index
        // 6, 9, 5, 7, 4 height
        // 4 < 7 = index 4
        // 7 > 5 = index 0
        
        for(let i = heights.length-1; i >= 0; i--) {
            if (heights[i] < heights[i-1])
                answer.unshift(i);
            else {
                let flag = false;
                for(let j = i-2; j >= 0; j--) {
                     if (heights[i] < heights[j]) {
                         answer.unshift(j+1);
                         flag = true;
                         break;
                     }
                }
                if (!flag)
                    answer.unshift(0);
            }   
        }
        
        return answer;
    }

    function solution_2(heights) {
        return heights.map((v, i) => {
            while (i) {
                i--;
                if (heights[i] > v) {
                    return i + 1;
                }
            }
            return 0;
        })
    }