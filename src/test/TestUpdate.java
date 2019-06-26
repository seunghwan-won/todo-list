import dao.TodoDao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUpdate {
    @Test
    public void updateDoing() {
        assertEquals(1,TodoDao.updateType(1L, "TODO"));
    }

    @Test
    public void updateDone() {
        assertEquals(1,TodoDao.updateType(5L, "DOING"));

    }
}
