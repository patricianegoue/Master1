package BRIDGE;

import java.util.List;

public class FormulaireHtml extends Formulaire{
    public FormulaireHtml(List<Widget> widgets) {
        super(widgets);
    }

    @Override
    public void implanter() {
        System.out.println("je suis un formulaire HTML, et voici mes widgets: \n");
        for(int i = 0; i<widgets.size(); i++) {
            widgets.get(i).getInput();
        }
    }
}
