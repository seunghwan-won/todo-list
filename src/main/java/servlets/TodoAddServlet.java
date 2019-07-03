package servlets;

import dao.TodoDao;
import dto.Todo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TodoAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String writer = request.getParameter("name");
        int sequence = Integer.parseInt(request.getParameter("sequence"));
        Todo todo = new Todo(title, writer, sequence);
        TodoDao.addTodo(todo.getTitle(), todo.getName(), todo.getSequence());
        response.sendRedirect("http://localhost:8080/");
    }
}
