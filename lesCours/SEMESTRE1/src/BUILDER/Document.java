package BUILDER;

public class Document {

    private final String name;
    private  final String path;
    private final float size;

    public Document(String name, String path, float size) {
        this.name = name;
        this.path = path;
        this.size = size;
    }

    public String getDoc() {
        return "name : " + name + ", path : " + path + ",  size : " + size + " Ko ";
    }
}
