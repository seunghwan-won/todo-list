var btn1 = document.querySelectorAll("#todos .todo-to-doing");

[].forEach.call(btn1, function (col) {
    col.addEventListener("click", todoToDoing, false);
});
function todoToDoing(e) {
    var test = document.querySelector("#doings");

    var test2 = e.path[1].querySelector(".todo-to-doing");
    test2.setAttribute("class", "doing-to-done");
    test.appendChild(e.path[1]);
    this.removeEventListener("click", arguments.callee);
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
    // test2.removeChild(test2.childNodes[13]);
    test2.removeChild(test2.querySelector(".doing-to-done"));
    this.removeEventListener("click", arguments.callee);
}

function reload() {
    var btn2 = document.querySelectorAll("#doings .doing-to-done");
    [].forEach.call(btn2, function (col) {
        col.addEventListener("click", doingToDone, false);
    });
}