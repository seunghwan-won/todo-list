package servlets;

import dao.TodoDao;
import dto.Todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TodoTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String type = request.getParameter("type");
        if(type.equals("TODO")) {
            TodoDao.updateType(id,type);
        } else if(type.equals("DOING")) {
            TodoDao.updateType(id,type);
        }
        List<Todo> todos = TodoDao.getTodos();
        List<Todo> doings = TodoDao.getDoings();
        List<Todo> dones = TodoDao.getDones();
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("todos", todos);
        request.setAttribute("doings", doings);
        request.setAttribute("dones", dones);
        dispatcher.forward(request, response);

    }
}
