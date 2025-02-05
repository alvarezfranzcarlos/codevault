import threading
import logging
from typing import List, Callable

# Configure logging
logging.basicConfig(level=logging.INFO, format="%(message)s")

def log_execution(func):
    """Decorator to log function execution details"""
    def wrapper(*args, **kwargs):
        logging.info(f"Executing {func.__name__} with args: {args}")
        result = func(*args, **kwargs)
        logging.info(f"Result: {result}")
        return result
    return wrapper

@log_execution
def quick_sort(arr: List[int], key: Callable[[int], int] = lambda x: x) -> List[int]:
    """Quick sort implementation with a key function for custom sorting"""
    if len(arr) <= 1:
        return arr

    pivot = arr[len(arr) // 2]
    left = [x for x in arr if key(x) < key(pivot)]
    middle = [x for x in arr if key(x) == key(pivot)]
    right = [x for x in arr if key(x) > key(pivot)]

    return quick_sort(left, key) + middle + quick_sort(right, key)

# Example Usage
dataset = [64, 34, 25, 12, 22, 11, 90, -10, 55, 100]

# Multi-threading execution
def threaded_sort():
    sorted_data = quick_sort(dataset)
    print("Sorted Data:", sorted_data)

thread = threading.Thread(target=threaded_sort)
thread.start()
thread.join()
