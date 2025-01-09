package BRIDGE_BACKUP.BRIDGE;

public class WidgetInput extends Widget {
    public WidgetInput(String type, String label, String value) {
        super(type, label, value);
    }

    @Override
    public void description() {
        System.out.println("Type de Widget : Input " + type + ", label : " + label + ", value : " + value);
    }
}
