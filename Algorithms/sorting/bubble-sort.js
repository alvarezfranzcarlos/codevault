class BubbleSort {
    constructor(data) {
        this.data = data;
    }

    sort() {
        let arr = [...this.data]; // Clone array to avoid mutation
        let n = arr.length;
        let swapped;

        for (let i = 0; i < n - 1; i++) {
            swapped = false;
            for (let j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
                    swapped = true;
                }
            }
            if (!swapped) break; // Stop early if no swaps occurred
        }
        return arr;
    }

    logSorted() {
        console.log("Original Array:", this.data);
        console.log("Sorted Array:", this.sort());
    }
}

// Example Usage
const dataset = [64, 34, 25, 12, 22, 11, 90, -10, 55, 100];
const sorter = new BubbleSort(dataset);
sorter.logSorted();
