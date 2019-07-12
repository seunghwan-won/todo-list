//
// let todoTemplate = document.querySelector("#todoTemplate").innerText;
// let todoBindTemplate = Handlebars.compile(todoTemplate);
var template = {
    createDoingTemplate() {

    },
    getTemplate() {

    }
}
let doingTemplate = document.querySelector("#doingTemplate").innerText;
let doingBindTemplate = Handlebars.compile(doingTemplate);

let doneTemplate = document.querySelector("#doneTemplate").innerText;
let doneBindTemplate = Handlebars.compile(doneTemplate);

let todoList = document.querySelector("#todoList");
let doingList = document.querySelector("#doingList");
let doneList = document.querySelector("#doneList");

todoList.addEventListener("click", function (v) {
    if(event.target.tagName === "BUTTON") {
        let data = event.target.parentNode;
        let todoId = data.querySelector(".id").innerHTML.split(":")[1];
        let todoTitle = data.querySelector("h4").innerText;
        let contents = data.querySelector("p").innerText.split(",");
        let todoRegDate = splitString(contents[0]);
        let todoName = splitString(contents[1]);
        let todoSequence = splitString(contents[2]);
        let doingObj = {
            id: todoId.trim(),
            type: "TODO",
            title: todoTitle.trim(),
            regDate: todoRegDate.trim(),
            name: todoName.trim(),
            sequence: todoSequence.trim()
        }
        doingList.innerHTML += doingBindTemplate(doingObj);
        data.remove();
        let ajax = new XMLHttpRequest();
        ajax.open("POST", "http://localhost:8080"+"/type?id="+doingObj.id +"&type=TODO", true);
        ajax.send();
    }

});

doingList.addEventListener("click", function (v) {
    let data = event.target.parentNode;
    let todoId = data.querySelector(".id").innerHTML.split(":")[1];
    let todoTitle = data.querySelector("h4").innerText;
    let contents = data.querySelector("p").innerText.split(",");
    let todoRegDate = splitString(contents[0]);
    let todoName = splitString(contents[1]);
    let todoSequence = splitString(contents[2]);
    let doingObj = {
        id: todoId.trim(),
        type: "DOING",
        title: todoTitle.trim(),
        regDate: todoRegDate.trim(),
        name: todoName.trim(),
        sequence: todoSequence.trim()
    }
    doneList.innerHTML += doneBindTemplate(doingObj);
    data.remove();
    let ajax = new XMLHttpRequest();
    ajax.open("POST", "http://localhost:8080"+"/type?id="+doingObj.id +"&type=DOING", true);
    ajax.send();
})


function splitString(str) {
    return str.split(":")[1];
}