package BRIDGE;

public class InputText implements Widget {

    private String label;

    public InputText(String label) {
        this.label = label;
    }

    @Override
    public void getInput() {
        System.out.println("Input Text: " + label);
    }

}
