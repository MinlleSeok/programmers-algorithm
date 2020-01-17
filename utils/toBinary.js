function toBinary(n) {
    if(n < 2) {
        return `${n}`;
    }

    return toBinary(parseInt(n / 2)) + `${parseInt(n % 2)}`;
}
