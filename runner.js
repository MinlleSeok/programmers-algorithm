function solution(participant, completion) {
    var answer = '';

function resolver() {

        participant.sort();
        completion.sort();
        
        for (let i = 0; i < participant.length; i++) {
            if(participant[i] !== completion[i])
                return participant[i];
            
            // failed
            // if(check[participant[i]])
            //     return participant[i];
            
            // if (completion.includes(participant[i]))
            //     check[participant[i]] = participant[i];
            // else
            //     return participant[i];

        }
        return result;
    }
    
    answer = resolver();
    return answer;
}


function solution2(participant, completion) {
   
    let dic  = {};
    for (let i = 0; i < completion.length; i++)
        dic[completion[i]] = dic[completion[i]] ? dic[completion[i]] + 1 : 1;
 
    for (let i = 0; i < participant.length; i++)
        if (dic[participant[i]])
            dic[participant[i]] = dic[participant[i]] - 1;
        else
            return participant[i];

}