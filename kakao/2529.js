function resolve(user_record, text_array, id_nick_dict) {
    const user = user_record.split(" ");
    const user_behavior = user[0];
    const user_id = user[1];
    switch (user_behavior) {
        case "Enter":
            text_array.push(`${user_id}님이 들어왔습니다.`);
            id_nick_dict[user_id] = user[2];
            break;

        case "Leave":
            text_array.push(`${user_id}님이 나갔습니다.`);
            break;

        case "Change":
            id_nick_dict[user_id] = user[2];
            break;
    }
}

function solve(record) {
    let text_array = [];
    let id_nick_dict = {};

    for(let i = 0; i < record.length; i++) {
        resolve(record[i], text_array, id_nick_dict);
    }
    
    for(let i = 0; i < text_array.length; i++) {
        const user_key = text_array[i].split("님")[0];
        text_array[i] = `${id_nick_dict[user_key]}님${text_array[i].split("님")[1]}`;
    }
    return text_array;
}

function solution(record) {
    var answer = [];
    answer = solve(record);
    return answer;
}

//
// Time out
//
// function resolve(user_record, text_array, id_array) {
//     const user = user_record.split(" ");
//     const user_behavior = user[0];
//     let mySet = new Set();

//     switch (user_behavior) {
//         case "Enter":
//             for (let i=0; i < text_array.length; i++) {
//                 if(id_array[i] === user[1])
//                     text_array[i] = `${user[2]}님${text_array[i].split("님")[1]}`;
//             }
//             id_array.push(user[1]);
//             text_array.push(`${user[2]}님이 들어왔습니다.`);
//             break;

//         case "Leave":
//             let leave_user_nick = '';
//             for (let i=0; i < id_array.length; i++) {
//                 if (id_array[i] === user[1])
//                     leave_user_nick = text_array[i].split("님")[0];
//             }
//             id_array.push(user[1]);
//             text_array.push(`${leave_user_nick}님이 나갔습니다.`);
//             break;

//         case "Change":
//             for (let i=0; i < text_array.length; i++) {
//                 if(id_array[i] === user[1])
//                     text_array[i] = `${user[2]}님${text_array[i].split("님")[1]}`;
//             }
//             break;
//     }
//     return text_array;
// }