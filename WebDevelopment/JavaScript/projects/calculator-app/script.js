const display = document.getElementById("display");
const buttons = document.getElementById("buttons");

const calculator = {
    currentValue: "",
    operations: ["+", "-", "*", "/"],

    append(value) {
        this.currentValue += value;
        display.value = this.currentValue;
    },

    calculate() {
        try {
            this.currentValue = eval(this.currentValue);
            display.value = this.currentValue;
        } catch {
            display.value = "Error";
            this.currentValue = "";
        }
    },

    clear() {
        this.currentValue = "";
        display.value = "";
    }
};

// Create buttons dynamically
["7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"].forEach(value => {
    const btn = document.createElement("button");
    btn.textContent = value;
    btn.onclick = () => {
        if (value === "=") {
            calculator.calculate();
        } else {
            calculator.append(value);
        }
    };
    buttons.appendChild(btn);
});

// Clear Button
const clearBtn = document.createElement("button");
clearBtn.textContent = "C";
clearBtn.onclick = () => calculator.clear();
buttons.appendChild(clearBtn);
