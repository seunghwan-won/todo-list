package Type;

public enum Type {
    TODO("TODO"), DOING("DOING"), DONE("DONE");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
