package BRIDGE;

public class InputRadio implements Widget {

    private String label;

    public InputRadio(String label) {
        this.label = label;
    }

    @Override
    public void getInput() {
        System.out.println("Input Radio: " + label);
    }

}
