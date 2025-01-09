package BRIDGE;

public class InputCheckbox implements Widget {

    private String label;

    public InputCheckbox(String label) {
        this.label = label;
    }

    @Override
    public void getInput() {
        System.out.println("Input Checkbox: " + label);
    }

}
