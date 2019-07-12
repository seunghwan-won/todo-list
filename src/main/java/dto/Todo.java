package dto;

import java.util.Objects;

public class Todo {
    private Long id;
    private String name;
    private String regDate;
    private int sequence;
    private String title;
    private String type;

    public Todo() {
    }

    public Todo(String title, String name, int sequence) {
        super();
        this.title = title;
        this.name = name;
        this.sequence = sequence;
    }

    public Todo(long id, String title, String name, int sequence, String type, String regDate) {
        super();
        this.id = id;
        this.title = title;
        this.name = name;
        this.sequence = sequence;
        this.type = type;
        this.regDate = regDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public int getSequence() {
        return sequence;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", regDate='" + regDate + '\'' +
                ", sequence=" + sequence +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return sequence == todo.sequence &&
                Objects.equals(id, todo.id) &&
                Objects.equals(name, todo.name) &&
                Objects.equals(regDate, todo.regDate) &&
                Objects.equals(title, todo.title) &&
                Objects.equals(type, todo.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, regDate, sequence, title, type);
    }
}
