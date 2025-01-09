package BRIDGE_BACKUP.BRIDGE;

import java.util.List;

public abstract class Formulaire {
    List<Widget> widgets;

    public Formulaire(List<Widget> widgets) {
        this.widgets = widgets;
    }
    public abstract void implanter();
}
