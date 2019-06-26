package dao;

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

    public static List<Todo> getTodos() {
        return new TodoDao().getTodoList();
    }

    public static int addTodo(String title, String name, int sequence) {
        return new TodoDao().insertTodo(title, name, sequence);
    }

    public static List<Todo> getDoings() {
        return new TodoDao().getDoingList();

    }

    public static List<Todo> getDones() {
        return new TodoDao().getDoneList();
    }

    public static int updateType(Long id, String type) {
        return type.equals("TODO") ? new TodoDao().typeDoing(id) : new TodoDao().typeDone(id);
    }

    private int typeDone(Long id) {
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "update todo set type='DONE' where id = ?";
        try (Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); PreparedStatement statement =
                connection.prepareStatement(query)) {
            statement.setLong(1, id);
            result = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private int typeDoing(Long id) {
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "update todo set type='DOING' where id = ?";
        try (Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); PreparedStatement statement =
                connection.prepareStatement(query)) {
            statement.setLong(1, id);
            result = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Todo> getDoneList() {
        List<Todo> todos = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "select * from todo where type='DONE'";
        try (Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); PreparedStatement statement =
                connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todos.add(new Todo(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4),
                        resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todos;
    }

    private List<Todo> getDoingList() {
        List<Todo> todos = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "select * from todo where type='DOING'";
        try (Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); PreparedStatement statement =
                connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todos.add(new Todo(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4),
                        resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todos;
    }

    private int insertTodo(String title, String name, int sequence) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "insert into todo(title, name, sequence) value (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); PreparedStatement statement =
                connection.prepareStatement(query);) {
            statement.setString(1, title);
            statement.setString(2, name);
            statement.setInt(3, sequence);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }

    private List<Todo> getTodoList() {
        List<Todo> todos = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "select * from todo where type='TODO'";
        try (Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); PreparedStatement statement =
                connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todos.add(new Todo(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4),
                        resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todos;
    }
}
