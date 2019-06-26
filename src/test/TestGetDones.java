import dao.TodoDao;
import dto.Todo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestGetDones {
    @Test
    public void dones() {
        List<Todo> todos = TodoDao.getDones();
        assertEquals(1, todos.size());
    }
}
