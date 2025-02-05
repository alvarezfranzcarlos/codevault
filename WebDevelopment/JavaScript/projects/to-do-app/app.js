const taskInput = document.getElementById("taskInput");
const addTaskBtn = document.getElementById("addTask");
const taskList = document.getElementById("taskList");

function addTask() {
    if (!taskInput.value.trim()) return;

    const li = document.createElement("li");
    li.textContent = taskInput.value;

    const removeBtn = document.createElement("button");
    removeBtn.textContent = "X";
    removeBtn.onclick = () => li.remove();

    li.appendChild(removeBtn);
    taskList.appendChild(li);

    taskInput.value = "";
}

addTaskBtn.onclick = addTask;
taskInput.addEventListener("keypress", (e) => {
    if (e.key === "Enter") addTask();
});
