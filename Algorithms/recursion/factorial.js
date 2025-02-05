class Factorial {
    constructor() {
        this.memo = new Map();
    }

    factorial(n) {
        if (n < 0) return undefined;
        if (n === 0 || n === 1) return 1;
        if (this.memo.has(n)) return this.memo.get(n);

        let result = n * this.factorial(n - 1);
        this.memo.set(n, result);
        return result;
    }

    factorialIterative(n) {
        if (n < 0) return undefined;
        let result = 1;
        for (let i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

// Example Usage
const factCalc = new Factorial();
console.log("Factorial (Recursive, Memoized):", factCalc.factorial(10));
console.log("Factorial (Iterative):", factCalc.factorialIterative(10));
