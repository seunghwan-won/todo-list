<%@ page import="dto.Todo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/earlyaccess/hanna.css">
    <link rel="stylesheet" type="text/css" href="css/index.css?after">
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
    <ul id="todos">
        <%
            List<Todo> todos = (List<Todo>) request.getAttribute("todos");
            for (Todo todo : todos) {
        %>
        <li class="todo">
            <h4><%=todo.getTitle()%>
            </h4>
            <p>등록날짜 : : <%=todo.getRegDate().split(" ")[0]%> <%=todo.getName()%> 우선순위 <%=todo.getSequence()%>
            </p>
            <form action="/type" method="post">
                <input type="hidden" name="_method" value="put"/>
                <input type="hidden" name="type" value="<%=todo.getType()%>">
                <input type="hidden" name="id" value=<%=todo.getId()%>>
                <button class="todo-to-doing" type="submit">-></button>
            </form>
        </li>
        <%}%>
    </ul>
</section>
<section>
    <h2 class="title">DOING</h2>
    <ul id="doings">
        <%
            List<Todo> doings = (List<Todo>) request.getAttribute("doings");
            for (Todo todo : doings) {
        %>
        <li class="todo">
            <h4><%=todo.getTitle()%>
            </h4>
            <p>등록날짜 : <%=todo.getRegDate().split(" ")[0]%> <%=todo.getName()%> 우선순위 <%=todo.getSequence()%>
            </p>
            <form action="/type" method="post">
                <input type="hidden" name="_method" value="put"/>
                <input type="hidden" name="type" value="<%=todo.getType()%>">
                <input type="hidden" name="id" value=<%=todo.getId()%>>
                <button class="todo-to-doing" type="submit">-></button>
            </form>
        </li>
        <%}%>
    </ul>
</section>
<section>
    <h2 class="title">DONE</h2>
    <ul id="dones">
        <%
            List<Todo> dones = (List<Todo>) request.getAttribute("dones");
            for (Todo todo : dones) {
        %>
        <li class="todo">
            <h4><%=todo.getTitle()%>
            </h4>
            <p>등록날짜 : : <%=todo.getRegDate().split(" ")[0]%> <%=todo.getName()%> 우선순위 <%=todo.getSequence()%>
            </p>
        </li>
        <%}%>
    </ul>
</section>

</body>
<script type="text/javascript" src="js/index.js">

</script>

</html>