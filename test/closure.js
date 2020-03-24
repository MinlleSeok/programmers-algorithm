var varvar = 10;
let letlet = 20;
const constconst = 30;

function calling() {
    var varvar = 100;
    let letlet = 200;
    const constconst = 300;

    function closure() {
        console.log(varvar);
        console.log(letlet);
        console.log(constconst);
    }

    const arrow = () => {
        console.log(varvar);
        console.log(letlet);
        console.log(constconst);
    }

    // return closure;
    return arrow;
}

// calling();
const a = calling();
a();