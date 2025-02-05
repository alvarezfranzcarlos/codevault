// Demonstrating loops, async operations, and generators
async function asyncLoop() {
    const fetchData = () => new Promise(resolve => setTimeout(() => resolve("Data Loaded"), 1000));

    for (let i = 1; i <= 5; i++) {
        console.log(`Iteration ${i}`);
        const data = await fetchData();
        console.log(data);
    }
}

function* numberGenerator() {
    let num = 0;
    while (num < 5) {
        yield num++;
    }
}

asyncLoop();

const gen = numberGenerator();
console.log([...gen]);
