import dao.TodoDao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInsertTodo {
    @Test
    public void insetTodo() {
        assertEquals(1,TodoDao.addTodo("test data", "tester", 3));
    }
}
