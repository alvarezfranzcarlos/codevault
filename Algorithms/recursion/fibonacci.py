from functools import lru_cache

class Fibonacci:
    def __init__(self):
        self.memo = {}

    def fibonacci_recursive(self, n):
        if n <= 0:
            return "Invalid Input"
        elif n == 1:
            return 0
        elif n == 2:
            return 1
        elif n in self.memo:
            return self.memo[n]
        
        self.memo[n] = self.fibonacci_recursive(n - 1) + self.fibonacci_recursive(n - 2)
        return self.memo[n]

    @lru_cache(maxsize=None)
    def fibonacci_dynamic(self, n):
        if n <= 0:
            return "Invalid Input"
        elif n == 1:
            return 0
        elif n == 2:
            return 1
        return self.fibonacci_dynamic(n - 1) + self.fibonacci_dynamic(n - 2)

# Example Usage
fib_calc = Fibonacci()
print("Fibonacci (Recursive, Memoized):", fib_calc.fibonacci_recursive(10))
print("Fibonacci (Dynamic Programming):", fib_calc.fibonacci_dynamic(10))
