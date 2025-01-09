package BRIDGE_BACKUP.BRIDGE;


public abstract class Widget {

    protected String type;
    protected String label;
    protected String value;
    public Widget(String type, String label, String value) {
        this.type = type;
        this.label = label;
        this.value = value;
    }
    public abstract void description();
}
