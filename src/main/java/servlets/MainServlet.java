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

public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        readData(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        readData(request, response);
    }

    private void readData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Todo> todoList = TodoDao.getTodoList();
        List<Todo> doingList = TodoDao.getDoingList();
        List<Todo> doneList = TodoDao.getDoneList();
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("todoList", todoList);
        request.setAttribute("doingList", doingList);
        request.setAttribute("doneList", doneList);
        dispatcher.forward(request, response);
    }
}
