let template = {
    createDoingTemplate() {
        let doingTemplate = document.querySelector("#doingTemplate").innerText;
        return Handlebars.compile(doingTemplate);
    },
    createDoneTemplate() {
        let doneTemplate = document.querySelector("#doneTemplate").innerText;
        return Handlebars.compile(doneTemplate);
    }
}

let transObj = {
    obj: {},
    createObject(data, type, contents) {
        this.obj = {
            id: data.querySelector(".id").innerHTML.split(":")[1].trim(),
            type: type,
            title: data.querySelector("h4").innerText.trim(),
            regDate: splitString(contents[0]).trim(),
            name: splitString(contents[1]).trim(),
            sequence: splitString(contents[2]).trim()
        }
        return this.obj;
    }
}

let todoList = document.querySelector("#todoList");
let doingList = document.querySelector("#doingList");
let doneList = document.querySelector("#doneList");
let BUTTON = "BUTTON";
let TODO = "TODO";
let DOING = "DOING";
let DONE = "DONE";

function getContents(data) {
    return data.querySelector("p").innerText.split(",");
}

todoList.addEventListener("click", () => {
    if (isButton(event)) {
        let data = event.target.parentNode;
        let contents = getContents(data);
        let todoObj = transObj.createObject(data, DOING, contents)
        let doingTemplate = template.createDoingTemplate();
        doingList.innerHTML += doingTemplate(todoObj);
        data.remove();
        let url = makeUrl(todoObj.id, TODO);
        sendDataByPost(url);
    }

});

doingList.addEventListener("click", () => {
    if (isButton(event)) {
        let data = event.target.parentNode;
        let contents = getContents(data);
        let doingObj = transObj.createObject(data, DONE, contents)
        let doneTemplate = template.createDoneTemplate();
        doneList.innerHTML += doneTemplate(doingObj);
        data.remove();
        let url = makeUrl(doingObj.id, DOING);
        sendDataByPost(url);
    }
})


function splitString(str) {
    return str.split(":")[1];
}

function makeUrl(id, type) {
    return "http://localhost:8080" + "/type?id=" + id + "&type=" + type;
}

function sendDataByPost(url) {
    let ajax = new XMLHttpRequest();
    ajax.open("POST", url, true);
    ajax.send();
}

function isButton(event) {
    return event.target.tagName === BUTTON;
}