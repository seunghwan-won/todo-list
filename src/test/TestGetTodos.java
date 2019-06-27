import dao.TodoDao;
import dto.Todo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestGetTodos {
    @Test
    public void getTodos() {
        List<Todo> todos = TodoDao.getTodoList();
        assertEquals(2, todos.size());
    }
}
