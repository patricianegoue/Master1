package BRIDGE;

public class InputButton implements Widget {

    private String label;

    public InputButton(String label) {
        this.label = label;
    }

    @Override
    public void getInput() {
        System.out.println("Input Button: " + label);
    }

}
