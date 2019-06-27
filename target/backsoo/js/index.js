var btn1 = document.querySelectorAll("#todos .todo-to-doing");

[].forEach.call(btn1, function (col) {
    col.addEventListener("click", todoToDoing, false);
});
function todoToDoing(e) {
    var test = document.querySelector("#doings");
    console.log(test);
    var test2 = e.path[1].querySelector(".todo-to-doing");
    console.log(test2);
    test2.setAttribute("class", "doing-to-done");
    test.appendChild(e.path[1]);
    reload();
}

var btn2 = document.querySelectorAll("#doings .doing-to-done");
[].forEach.call(btn2, function (col) {
    col.addEventListener("click", doingToDone, false);
});

function doingToDone(e) {
    var test = document.querySelector("#dones");
    test.appendChild(e.path[1]);
    var test2 = test.lastChild;
    test2.removeChild(test2.querySelector(".doing-to-done"));
}

function reload() {
    var btn2 = document.querySelectorAll("#doings .doing-to-done");
    [].forEach.call(btn2, function (col) {
        col.addEventListener("click", doingToDone, false);
    });
}