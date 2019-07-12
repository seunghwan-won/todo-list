<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/earlyaccess/hanna.css">
    <link rel="stylesheet" type="text/css" href="css/index.css?after?">
</head>

<body>
<header>
    <div>
        <div class="logo">나의 해야할 일들</div>
        <div class="button"><a href="/create" role="button">새로운 TODO 등록</a></div>
    </div>
</header>
<aside id="blank"></aside>
<section>
    <h2 class="title">TODO</h2>
    <ul id="todoList">
        <c:forEach items="${todoList}" var="todo">
            <li class="todo">
                <h4>${todo.title}
                </h4>
                <p>등록날짜 : ${todo.regDate.split(" ")[0]}, 작성자 : ${todo.name}, 우선순위 : ${todo.sequence}
                </p>
                <label class="id"> id : ${todo.id}</label>
                <label> type : ${todo.type} </label>
                <button class="todo-to-doing">-></button>
            </li>
        </c:forEach>
    </ul>
</section>
<section>
    <h2 class="title">DOING</h2>
    <ul id="doingList">
        <c:forEach items="${doingList}" var="todo">
            <li class="doing">
                <h4>${todo.title}
                </h4>
                <p>등록날짜 : ${todo.regDate.split(" ")[0]}, 작성자 : ${todo.name}, 우선순위 : ${todo.sequence}
                </p>
                <label class="id"> id : ${todo.id}</label>
                <label> type : ${todo.type} </label>
                <button class="doing-to-done">-></button>
            </li>
        </c:forEach>
    </ul>
</section>
<section>
    <h2 class="title">DONE</h2>
    <ul id="doneList">
        <c:forEach items="${doneList}" var="todo">
            <li class="done">
                <h4>${todo.title}
                </h4>
                <p>등록날짜 : ${todo.regDate.split(" ")[0]}, 작성자 : ${todo.name}, 우선순위 : ${todo.sequence}
                </p>
            </li>
        </c:forEach>
    </ul>
</section>

<script type="todo-Template" id="todoTemplate">
    <li class="todo">
        <h4>{{title}}</h4>
        <p>등록 날짜 : {{regDate}}, 작성자 : {{name}}, 우선순위 : {{sequence}}</p>
        <label class="id"> id : {{id}}</label>
        <label> type : {{type}} </label>
        <button class="todo-to-doing">-></button>
    </li>
</script>
<script type="doing-Template" id="doingTemplate">
    <li class="doing">
        <h4>{{title}}</h4>
        <p>등록 날짜 : {{regDate}}, 작성자 : {{name}}, 우선순위 : {{sequence}}</p>
        <button class="doing-to-done">-></button>
        <label class="id"> id : {{id}}</label>
        <label> type : {{type}} </label>
    </li>
</script>

<script type="done-Template" id="doneTemplate">
    <li class="done">
        <h4>{{title}}</h4>
        <p>등록 날짜 : {{regDate}}, 작성자 : {{name}}, 우선순위 : {{sequence}}</p>
        <label class="id"> id : {{id}}</label>
        <label> type : {{type}} </label>
    </li>
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.1.2/handlebars.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>


</body>
</html>