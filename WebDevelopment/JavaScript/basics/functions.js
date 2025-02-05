// Function composition, closures, and currying
const multiply = (a, b) => a * b;
const add = (a, b) => a + b;

function compose(f, g) {
    return function(x, y) {
        return f(g(x, y), y);
    };
}

const multiplyThenAdd = compose(add, multiply);
console.log(multiplyThenAdd(3, 2)); // (3*2) + 2 = 8
