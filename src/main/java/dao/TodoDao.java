package dao;

import Type.Type;
import dto.Todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private static final String DBURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String DBUSER = "tester";
    private static final String DBPASSWORD = "1234";
    private static final Type TODO = Type.TODO;
    private static final Type DOING = Type.DOING;
    private static final Type DONE = Type.DONE;
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    public static int addTodo(String title, String name, int sequence) {
        return new TodoDao().insertTodo(title, name, sequence);
    }

    public static List<Todo> getTodoList() {
        return new TodoDao().getList(TODO.getType());
    }

    public static List<Todo> getDoingList() {
        return new TodoDao().getList(DOING.getType());

    }

    public static List<Todo> getDoneList() {
        return new TodoDao().getList(DONE.getType());
    }

    public static int updateType(Long id, String type) {
        return new TodoDao().changeType(id, type);
    }

    private int changeType(Long id, String type) {
        int result = 0;
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "update todo set type=? where id = ?";
        try (Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); PreparedStatement statement =
                connection.prepareStatement(query)) {
            statement.setString(1, type);
            statement.setLong(2, id);
            result = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Todo> getList(String type) {
        List<Todo> todoList = new ArrayList<>();
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "select * from todo where type=?";
        try (Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); PreparedStatement statement =
                connection.prepareStatement(query)) {
            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todoList.add(new Todo(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4),
                        resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todoList;
    }

    private int insertTodo(String title, String name, int sequence) {
        int result = 0;
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "insert into todo(title, name, sequence) value (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); PreparedStatement statement =
                connection.prepareStatement(query)) {
            statement.setString(1, title);
            statement.setString(2, name);
            statement.setInt(3, sequence);
            result = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
