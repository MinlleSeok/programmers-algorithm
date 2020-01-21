function solution(array, commands) {
    var answer = [];
    
    for (let x = 0; x < commands.length; x++){
        // const i = commands[x][0];
        // const j = commands[x][1];
        // const k = commands[x][2];
        
        const [ i, j, k ] = commands[x];
        
        const new_array = array.filter((a, idx) => idx >= i - 1 && idx < j );
        
        // console.log(new_array)
        // 그냥 sort() => 문자열로 인식할 수 있음 35 > 100
        new_array.sort((a, b) => a - b);
        
        // console.log(new_array)
        
        answer.push(new_array[k-1]);
    }
    
    return answer;
}

function solution_2(array, commands) {
    
    return commands.map(v => {
        // return array.slice(v[0] - 1, v[1]).sort((a, b) => a - b).slice(v[2] - 1, v[2])[0];
        return array.slice(v[0] - 1, v[1]).sort((a, b) => a - b)[v[2] - 1];
    });
}