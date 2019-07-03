import dao.TodoDao;
import dto.Todo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestGetDoings {
    @Test
    public void getDoings() {
        List<Todo> todos = TodoDao.getDoingList();
        assertEquals(1, todos.size());
    }
}
