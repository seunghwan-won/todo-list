var btn1 = document.querySelectorAll("#todoList #todo-to-doing");

[].forEach.call(btn1, function (col) {
    col.addEventListener("click", todoToDoing, false);
});
function todoToDoing(e) {
    var test = document.querySelector("#doingList");
    var test2 = e.path[1].querySelector(".todo-to-doing");
    test2.setAttribute("class", "doing-to-done");
    test.appendChild(e.path[1]);
    reload();
}

var btn2 = document.querySelectorAll("#doingList #doing-to-done");
[].forEach.call(btn2, function (col) {
    col.addEventListener("click", doingToDone, false);
});

function doingToDone(e) {
    var test = document.querySelector("#doneList");
    test.appendChild(e.path[1]);
    var test2 = test.lastChild;
    test2.removeChild(test2.querySelector(".doing-to-done"));
}

function reload() {
    var btn2 = document.querySelectorAll("#doneList .doing-to-done");
    [].forEach.call(btn2, function (col) {
        col.addEventListener("click", doingToDone, false);
    });
}