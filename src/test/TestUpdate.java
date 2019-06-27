import Type.Type;
import dao.TodoDao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUpdate {
    @Test
    public void updateDoing() {
        assertEquals(1, TodoDao.updateType(9L, Type.DONE.getType()));
    }

    @Test
    public void updateDone() {
        assertEquals(1, TodoDao.updateType(1L, "DOING"));

    }
}
