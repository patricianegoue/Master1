package BRIDGE;

public class InputSelect implements Widget {

    private String label;

    public InputSelect(String label) {
        this.label = label;
    }

    @Override
    public void getInput() {
        System.out.println("Input Select: " + label);
    }

}
