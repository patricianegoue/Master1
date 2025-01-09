package BRIDGE_BACKUP.BRIDGE;

import java.util.List;

public class FormulaireHtml extends Formulaire {
    public FormulaireHtml(List<Widget> widgets) {
        super(widgets);
    }

    @Override
    public void implanter() {
        System.out.println("Implentation des widgtes dans le formulaire =====> \n");
        for(int i = 0; i<widgets.size(); i++) {
            widgets.get(i).description();
        }
    }
}
