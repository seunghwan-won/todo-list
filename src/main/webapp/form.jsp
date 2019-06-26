<%--
  Created by IntelliJ IDEA.
  User: seunghwanwon
  Date: 2019-06-25
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/form.css">
</head>
<body>
<header>
    <h2>할일 등록</h2>
</header>
<section>
    <form action="/add" method="post">
        <label for="title">어떤일인가요</label><br>
        <input type="text" name="title" id="title" value="" placeholder="swift공부하기(24자까지)" maxlength="24"><br>
        <label for="name">누가 할일인가요</label><br>
        <input type="text" name="name" id="name" value="" placeholder="홍길동"><br>
        <label for="sequence">우선순위를 선택하세요</label>
        <ul>
            <input type="radio" name="sequence" value="1">1순위
            <input type="radio" name="sequence" value="2">2순위
            <input type="radio" name="sequence" value="3">3순위
        </ul>
        <ul>
            <li id="back"><a href="/" role="button">
                <이전
            </a></li>
            <li id="submit">
                <button type="submit">제출</button>
            </li>
            <li id="reset">
                <button type="reset">내용지우기</button>
            </li>
        </ul>
    </form>
</section>
<footer>

</footer>
</body>
<script type="text/javascript" src="/js/form.js"></script>
</html>
